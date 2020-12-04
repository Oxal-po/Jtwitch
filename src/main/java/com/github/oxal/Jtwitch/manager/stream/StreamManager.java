package com.github.oxal.Jtwitch.manager.stream;

import com.github.oxal.Jtwitch.JTwitchClient;
import com.github.oxal.Jtwitch.event.stream.StreamEvent;
import com.github.oxal.Jtwitch.listener.stream.StreamListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOffListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOnListener;
import com.github.oxal.Jtwitch.stream.Stream;
import com.github.oxal.Jtwitch.stream.Streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StreamManager implements Runnable {

    private StreamOnListener streamOnListener;
    private StreamOffListener streamOffListener;
    private StreamListener streamListener;
    private String nameGame;
    private Collection<Stream> oldList;
    private Collection<Stream> newList;
    public static int DELAY = 60000;
    private SimpleDateFormat dateFormat;

    public StreamManager(StreamOnListener streamOnListener, StreamOffListener streamOffListener, StreamListener streamListener, String game) {
        this.streamOnListener = streamOnListener;
        this.streamOffListener = streamOffListener;
        this.streamListener = streamListener;
        this.nameGame = game;
        oldList = new ArrayList<>();
        newList = new ArrayList<>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");;
    }

    public StreamManager(JTwitchClient client, String game){
        this(client, client, client, game);
    }


    @Override
    public void run() {
        List<Stream> on, off;
        oldList = Streams.getAllStreamByGame(nameGame);
        while (true){
            newList = Streams.getAllStreamByGame(nameGame);
            on = getOnStream();
            off = getOffStream();
            for (Stream stream : on){
                streamOnListener.onStreamOn(() -> stream);
                streamListener.onStream(new StreamEvent() {
                    @Override
                    public boolean isOn() {
                        return true;
                    }

                    @Override
                    public Stream getStream() {
                        return stream;
                    }
                });
            }
            for (Stream stream : off){
                streamOffListener.onStreamOff(() -> stream);
                streamListener.onStream(new StreamEvent() {
                    @Override
                    public boolean isOn() {
                        return false;
                    }

                    @Override
                    public Stream getStream() {
                        return stream;
                    }
                });
            }

            oldList = new ArrayList<>(newList);
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    //todo cassé car des live se co puis deco

    private List<Stream> getOffStream(){
        ArrayList<Stream> clone = new ArrayList<>(oldList);
        for (Stream stream : newList){
            for (int i = 0; i<clone.size(); i++){
                if (stream.get_id() == clone.get(i).get_id()){
                    clone.remove(i);
                    i--;
                }
            }
        }
        return clone;
    }

    private List<Stream> getOnStream(){
        ArrayList<Stream> clone = new ArrayList<>(newList);
        clone.removeAll(oldList);
        clone = new ArrayList(clone.stream().filter(s -> {
            try {
                Date create = dateFormat.parse(s.getCreated_at());
                Date thisDate = Calendar.getInstance().getTime();
                int delay = DELAY < 60000 ? 120000 : DELAY*2;
                thisDate.setTime(thisDate.getTime() - delay - 6000000);
                return thisDate.before(create);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList()));
        return clone;
    }
}

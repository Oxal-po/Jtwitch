package com.github.oxal.Jtwitch.manager.stream;

import com.github.oxal.Jtwitch.JTwitchClient;
import com.github.oxal.Jtwitch.event.stream.StreamEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOffEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOnEvent;
import com.github.oxal.Jtwitch.listener.stream.StreamListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOffListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOnListener;
import com.github.oxal.Jtwitch.stream.Stream;
import com.github.oxal.Jtwitch.stream.Streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class StreamManager extends CompletableFuture<Void> {

    private StreamOnListener streamOnListener;
    private StreamOffListener streamOffListener;
    private StreamListener streamListener;
    private String nameGame;
    private Collection<Stream> oldList;
    private Collection<Stream> newList;

    public StreamManager(StreamOnListener streamOnListener, StreamOffListener streamOffListener, StreamListener streamListener, String game) {
        this.streamOnListener = streamOnListener;
        this.streamOffListener = streamOffListener;
        this.streamListener = streamListener;
        this.nameGame = game;
        oldList = Streams.getAllStreamByGame(game);
        newList = new ArrayList<>();

        run();
    }

    public StreamManager(JTwitchClient client, String game){
        this(client, client, client, game);
    }


    public void run() {
        ArrayList<Stream> on, off;

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
        }
    }

    private ArrayList<Stream> getOffStream(){
        ArrayList<Stream> clone = new ArrayList<>(oldList);
        clone.removeAll(newList);
        return clone;
    }

    private ArrayList<Stream> getOnStream(){
        ArrayList<Stream> clone = new ArrayList<>(newList);
        clone.removeAll(oldList);
        return clone;
    }
}

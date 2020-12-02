package com.github.oxal.Jtwitch;

import com.github.oxal.Jtwitch.event.stream.StreamEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOffEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOnEvent;
import com.github.oxal.Jtwitch.listener.stream.StreamListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOffListener;
import com.github.oxal.Jtwitch.listener.stream.StreamOnListener;
import com.github.oxal.Jtwitch.manager.stream.StreamManager;
import com.github.oxal.Jtwitch.stream.Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class JTwitchClient implements StreamListener, StreamOnListener, StreamOffListener{
    private static String id;
    private static Collection<StreamListener> streamListeners;
    private static Collection<StreamOnListener> streamOnListeners;
    private static Collection<StreamOffListener> streamOffListeners;

    public static String[] commands;
    public static String PATH = "https://api.twitch.tv/kraken/streams/";
    public static String LIMIT = "limit=%d";
    public static String GAME = "game=%s";
    public static String PAGE = "offset=%d";

    public static JTwitchClient context = new JTwitchClient();

    public JTwitchClient(String id) {
        setId(id);
        streamListeners = new ArrayList<>();
        streamOnListeners = new ArrayList<>();
        streamOnListeners.add(event -> {
            System.out.println("le live de " + event.getStream().getChannel().getDisplay_name() + " vient d'être lancer : " + event.getStream().getChannel().getStatus());
        });
        streamOffListeners = new ArrayList<>();
        streamOffListeners.add(event -> {
            System.out.println("le live de " + event.getStream().getChannel().getDisplay_name() + " vient de s'éteindre");
        });
    }

    public JTwitchClient() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        JTwitchClient.id = id;
        commands = new String[] {"curl", "-H", "Accept:application/vnd.twitchtv.v5+json", "-H", "Client-ID: " + id};
    }

    public static Collection<StreamListener> getStreamListeners() {
        return streamListeners;
    }

    public static void addStreamListeners(StreamListener streamListener) {
        JTwitchClient.streamListeners.add(streamListener);
    }

    public static Collection<StreamOnListener> getStreamOnListeners() {
        return streamOnListeners;
    }

    public static void addStreamOnListeners(StreamOnListener streamOnListener) {
        JTwitchClient.streamOnListeners.add(streamOnListener);
    }

    public static Collection<StreamOffListener> getStreamOffListeners() {
        return streamOffListeners;
    }

    public static void addStreamOffListeners(StreamOffListener streamOffListener) {
        JTwitchClient.streamOffListeners.add(streamOffListener);
    }

    public String process(String... req){
        StringBuilder response = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(req);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public String request(String... req){
        String[] request = new String[commands.length + req.length];
        for (int i = 0; i<commands.length; i++){
            request[i] = commands[i];
        }
        for (int i = 0; i<req.length; i++){
            request[commands.length + i] = req[i];
        }
        return process(request);
    }

    public void searchGame(String game){
        Thread t = new Thread("Stream Listener"){
            @Override
            public void run() {
                new StreamManager(new JTwitchClient(), game);
            }
        };

        t.start();
    }

    @Override
    public void onStream(StreamEvent event) {
        for (StreamListener streamListener: streamListeners){
            streamListener.onStream(event);
        }
    }

    @Override
    public Stream getStream() {
        return null;
    }

    @Override
    public void onStreamOff(StreamOffEvent event) {
        for (StreamOffListener streamOffListener: streamOffListeners){
            streamOffListener.onStreamOff(event);
        }
    }

    @Override
    public void onStreamOn(StreamOnEvent event) {
        for (StreamOnListener streamOnListener: streamOnListeners){
            streamOnListener.onStreamOn(event);
        }
    }
}

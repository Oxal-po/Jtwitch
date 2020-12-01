package com.github.oxal.Jtwitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JTwitchClient {
    private static String id;
    public static String[] commands;
    public static String PATH = "https://api.twitch.tv/kraken/streams/";
    public static String LIMIT = "limit=%d";
    public static String GAME = "game=%s";
    public static String PAGE = "offset=%d";

    public static JTwitchClient context = new JTwitchClient();

    public JTwitchClient(String id) {
        setId(id);
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
}

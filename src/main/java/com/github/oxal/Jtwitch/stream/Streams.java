package com.github.oxal.Jtwitch.stream;

import com.github.oxal.Jtwitch.JTwitchClient;
import com.github.oxal.Jtwitch.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Streams {

    private ArrayList<Stream> streams;

    public Streams(ArrayList<Stream> streams) {
        this.streams = streams;
    }

    public ArrayList<Stream> getStreams() {
        return streams;
    }

    public void setStreams(ArrayList<Stream> streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "Streams{" +
                "streams=" + streams +
                '}';
    }

    public static ArrayList<Stream> getListStreamsByGame(String game, int limit, int page){
        StringBuilder builder = new StringBuilder(JTwitchClient.PATH + "?");
        builder.append(String.format(JTwitchClient.GAME, game.replace(" ", "+")));
        if (limit > 100){
            builder.append(String.format("&" + JTwitchClient.LIMIT, 100));
        }else if(limit > 0){
            builder.append("&" + String.format(JTwitchClient.LIMIT, limit));
        }

        if (page > 0){
            builder.append(String.format("&" + JTwitchClient.PAGE, page));
        }
        String response = JTwitchClient.context.request("-X", "GET", builder.toString());
        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, Streams.class).streams;
    }

    public static Streams getStreamsByGame(String game, int limit, int page){
        StringBuilder builder = new StringBuilder(JTwitchClient.PATH + "?");
        builder.append(String.format(JTwitchClient.GAME, game.replace(" ", "+")));
        if (limit > 100){
            builder.append(String.format("&" + JTwitchClient.LIMIT, 100));
        }else if(limit > 0){
            builder.append("&" + String.format(JTwitchClient.LIMIT, limit));
        }

        if (page > 0){
            builder.append(String.format("&" + JTwitchClient.PAGE, page));
        }
        String response = JTwitchClient.context.request("-X", "GET", builder.toString());
        final Gson gson = new GsonBuilder().create();

        return gson.fromJson(response, Streams.class);
    }
}
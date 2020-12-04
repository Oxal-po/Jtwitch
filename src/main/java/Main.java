
import com.github.oxal.Jtwitch.JTwitchClient;
import com.github.oxal.Jtwitch.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.github.oxal.Jtwitch.stream.Streams;

import java.io.*;
import java.util.ArrayList;

public class Main {

    private final static String ID_CLIENT = "sejn8fc3083n7fne5248ds4eozllo8";

    public static void main(String[] args) {
        JTwitchClient client = new JTwitchClient(ID_CLIENT);
        client.searchGame("waven", 60000);
        client.addStreamOnListeners(event -> {
            System.out.println("le live de " + event.getStream().getChannel().getDisplay_name() + " vient d'être lancer : " + event.getStream().getChannel().getStatus());
        });
        client.addStreamOffListeners(event -> {
            System.out.println("le live de " + event.getStream().getChannel().getUrl());
        });
    }
}

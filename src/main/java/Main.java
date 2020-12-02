
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
        client.searchGame("wakfu");
        String name = "wakfu";
        final ArrayList<Stream> groupe = Streams.getAllStreamByGame(name);
        //System.out.println(response.toString());

        System.out.println(String.format("il y a %d qui joue actuellement à %s", groupe.size(), name));
        System.out.println(groupe.size());
    }
}

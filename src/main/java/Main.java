
import com.github.oxal.Jtwitch.JTwitchClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.github.oxal.Jtwitch.stream.Streams;

import java.io.*;

public class Main {


    public static void main(String[] args) {
        JTwitchClient client = new JTwitchClient("sejn8fc3083n7fne5248ds4eozllo8");

        final Streams groupe = Streams.getStreamsByGame("fortnite", 10, 0);
        //System.out.println(response.toString());
        System.out.println(groupe);

        System.out.println(groupe.getStreams().size());
    }
}

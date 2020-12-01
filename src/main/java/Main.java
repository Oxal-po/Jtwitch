
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import stream.Stream;
import stream.Streams;

import java.io.*;

public class Main {


    public static void main(String[] args) {
        try {
            String[] commands = new String[] {"curl", "-H", "Accept:application/vnd.twitchtv.v5+json", "-H", "Client-ID: sejn8fc3083n7fne5248ds4eozllo8", "-X", "GET", "https://api.twitch.tv/kraken/streams/?game=Fortnite&limit=100"};
            Process process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            final Gson gson = new GsonBuilder().create();

            final Streams groupe = gson.fromJson(response.toString(), Streams.class);
            //System.out.println(response.toString());
            System.out.println(groupe);

            System.out.println(groupe.getStreams().size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

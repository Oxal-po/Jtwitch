package stream;

import java.util.ArrayList;
import java.util.Arrays;

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
}

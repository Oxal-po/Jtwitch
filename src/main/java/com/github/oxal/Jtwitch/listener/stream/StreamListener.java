package com.github.oxal.Jtwitch.listener.stream;

import com.github.oxal.Jtwitch.event.stream.StreamEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOffEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOnEvent;

public interface StreamListener extends StreamOffEvent, StreamOnEvent {

    void onStream(StreamEvent event);
}

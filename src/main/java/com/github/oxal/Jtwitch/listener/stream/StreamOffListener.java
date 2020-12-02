package com.github.oxal.Jtwitch.listener.stream;

import com.github.oxal.Jtwitch.event.stream.StreamOffEvent;
import com.github.oxal.Jtwitch.listener.TwitchListener;

@FunctionalInterface
public interface StreamOffListener extends TwitchListener {

    void onStreamOff(StreamOffEvent event);
}

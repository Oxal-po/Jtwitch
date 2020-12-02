package com.github.oxal.Jtwitch.listener.stream;

import com.github.oxal.Jtwitch.event.stream.StreamOnEvent;
import com.github.oxal.Jtwitch.listener.TwitchListener;

@FunctionalInterface
public interface StreamOnListener extends TwitchListener {

    void onStreamOn(StreamOnEvent event);
}

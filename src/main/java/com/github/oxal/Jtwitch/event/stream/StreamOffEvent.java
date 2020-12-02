package com.github.oxal.Jtwitch.event.stream;

import com.github.oxal.Jtwitch.event.TwitchEvent;
import com.github.oxal.Jtwitch.stream.Stream;

@FunctionalInterface
public interface StreamOffEvent extends TwitchEvent {
    Stream getStream();
}

package com.github.oxal.Jtwitch.event.stream;

import com.github.oxal.Jtwitch.stream.Stream;

public interface StreamEvent extends StreamOffEvent, StreamOnEvent {
    boolean isOn();
}

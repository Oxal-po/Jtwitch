package com.github.oxal.Jtwitch.manager.stream;

import com.github.oxal.Jtwitch.event.stream.StreamEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOffEvent;
import com.github.oxal.Jtwitch.event.stream.StreamOnEvent;

public interface StreamListenerManager {

    StreamOnEvent streamOn();
    StreamOffEvent streamOff();
    StreamEvent streamEvent();
}

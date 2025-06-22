package com.recceda.model;

import com.recceda.model.event.Event;
import com.recceda.model.event.Meta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class WebEvent {

    private Meta meta;
    private List<Event> events;
    private Instant timestamp;

}

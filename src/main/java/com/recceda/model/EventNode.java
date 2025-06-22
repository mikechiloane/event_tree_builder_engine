package com.recceda.model;


import com.recceda.model.event.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventNode {
    private final Event event;
    private final int level;
    private EventNode parent;
    private EventNode[] children;
    private int childCount;

    public EventNode(Event event, int level) {
        this.event = event;
        this.level = level;
    }
}

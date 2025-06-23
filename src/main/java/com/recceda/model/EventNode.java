package com.recceda.model;


import com.recceda.model.event.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EventNode {

    private String id;
    private final Event event;
    private final int level;
    private String parentId;
    private List<String> children;
    private int childCount;

    public EventNode(Event event, int level) {
        this.event = event;
        this.level = level;
        this.id = generateId();
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}

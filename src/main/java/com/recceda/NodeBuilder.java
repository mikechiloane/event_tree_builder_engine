package com.recceda;

import com.recceda.model.EventNode;
import com.recceda.model.WebEvent;
import com.recceda.model.event.Event;

import java.util.List;

public class NodeBuilder {

    public WebEvent webEvent;
    public int level;
    public List<NodeBuilder> children;

    public NodeBuilder(WebEvent webEvent, int level, List<NodeBuilder> children) {
        this.webEvent = webEvent;
        this.level = level;
        this.children = children;
    }

    public EventNode buildNode(Event event) {
        return new EventNode(event, getLevel(event));
    }

    public static int getLevel(Event event) {
        String eventPath = event.getPage().getPath();
        if (eventPath == null || eventPath.isEmpty()) {
            return 0;
        }
        return (int) eventPath.chars().filter(ch -> ch == '/').count() -1;
    }


}

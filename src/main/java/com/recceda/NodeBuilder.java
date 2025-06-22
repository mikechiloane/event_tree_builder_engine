package com.recceda;

import com.recceda.model.WebEvent;

import java.util.List;

public class NodeGenerator {

    public WebEvent webEvent;
    public int level;
    public List<NodeGenerator> children;

    public NodeGenerator(WebEvent webEvent, int level, List<NodeGenerator> children) {
        this.webEvent = webEvent;
        this.level = level;
        this.children = children;
    }


}

package com.recceda.pipeline.stages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.recceda.model.EventNode;
import com.recceda.pipeline.PipelineStage;

public class EventGroupingStage implements PipelineStage<List<EventNode>, Map<String, List<EventNode>>> {

    private final String stageName = "EventGroupingStage";

    @Override
    public Map<String, List<EventNode>> process(Object input) {
        List<EventNode> eventNodes = (List<EventNode>) input;
        Map<String, List<EventNode>> groupedEvents = eventNodes.stream()
                .collect(Collectors.groupingBy(this::getEventPath));
        return groupedEvents;

    }

    public String getEventPath(EventNode eventNode) {
        return eventNode.getEvent().getPage().getPath();
    }

    @Override
    public String getName() {
        return stageName;
    }

    @Override
    public PipelineStage<Map<String, List<EventNode>>, ?> getNextStage() {
        return null;
    }


}

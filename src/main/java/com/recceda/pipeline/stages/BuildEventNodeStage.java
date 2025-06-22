package com.recceda.pipeline.stages;

import com.recceda.model.EventNode;
import com.recceda.model.event.Event;
import com.recceda.pipeline.PipelineStage;

import java.util.List;
import java.util.stream.Collectors;

public class BuildEventNodeStage implements PipelineStage<List<Event>, List<EventNode>> {

    private final String stageName = "BuildEventNodeStage";

    public static int getLevel(Event event) {
        String eventPath = event.getPage().getPath();
        if (eventPath == null || eventPath.isEmpty()) {
            return 0;
        }
        return (int) eventPath.chars().filter(ch -> ch == '/').count() - 1;
    }

    @Override
    public List<EventNode> process(Object input) {
        List<Event> events = (List<Event>) input;
        return events.stream()
                .map(this::buildNode)
                .collect(Collectors.toList());
    }

    public EventNode buildNode(Event event) {
        return new EventNode(event, getLevel(event));
    }

    @Override
    public String getName() {
        return stageName;
    }

    @Override
    public PipelineStage<List<EventNode>, ?> getNextStage() {
        return null;
    }
}

package com.recceda.pipeline.stages;

import com.recceda.model.WebEvent;
import com.recceda.model.event.Event;
import com.recceda.pipeline.PipelineStage;

import java.util.ArrayList;
import java.util.List;

public class LoadEventsStage implements PipelineStage<List<WebEvent>, List<Event>> {

    private final String stageName = "LoadEventsStage";


    @Override
    public List<Event> process(Object input) {
        List<Event> events = new ArrayList<>();
        if (!(input instanceof List<?>)) {
            return events;
        }
        List<WebEvent> webEventsInput = (List<WebEvent>) input;
        webEventsInput.forEach(webEvent -> {
            List<Event> webEvents = webEvent.getEvents();
            if (webEvents != null) {
                events.addAll(webEvents);
            }
        });
        return events;
    }

    @Override
    public String getName() {
        return stageName;
    }

    @Override
    public PipelineStage getNextStage() {
        // Return the next stage in the pipeline, or null if this is the last stage
        return null;
    }
}

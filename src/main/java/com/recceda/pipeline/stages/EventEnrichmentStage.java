package com.recceda.pipeline.stages;

import com.recceda.model.EventNode;
import com.recceda.pipeline.PipelineStage;

import java.util.List;

public class EventEnrichmentStage implements PipelineStage<List<EventNode>, List<EventNode>> {
    @Override
    public List<EventNode> process(Object input) {
        List<EventNode> eventNodes = (List<EventNode>) input;

        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public PipelineStage<List<EventNode>, ?> getNextStage() {
        return null;
    }
}

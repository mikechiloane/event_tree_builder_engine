package com.recceda.pipeline.stages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recceda.model.EventNode;
import com.recceda.pipeline.PipelineStage;

import java.util.List;
import java.util.Map;

public class SaveToFileStage implements PipelineStage<Map<EventNode, List<EventNode>>, Void> {

    private final String stageName = "SaveToFile";

    @Override
    public Void process(Object input) {

        System.out.println("Saving data to file: " + input);
        List<EventNode> groupedEvents = ( List<EventNode>) input;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new java.io.File("grouped_events.json"), groupedEvents);
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String getName() {
        return stageName;
    }
}

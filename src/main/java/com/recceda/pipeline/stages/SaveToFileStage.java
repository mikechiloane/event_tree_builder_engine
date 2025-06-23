package com.recceda.pipeline.stages;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recceda.model.EventNode;
import com.recceda.pipeline.PipelineStage;

public class SaveToFileStage implements PipelineStage<List<EventNode>, List<EventNode>> {

    private final String stageName = "SaveToFile";
    private final static Logger logger = Logger.getLogger(SaveToFileStage.class.getName());

    @Override
    public List<EventNode> process(Object input) {

        logger.info(stageName + " started processing.");
        List<EventNode> groupedEvents = (List<EventNode>) input;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new java.io.File("grouped_events.json"), groupedEvents);
            logger.info("Data saved to grouped_events.json successfully.");
            return groupedEvents;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving data to file: {0}", e.getMessage());
        }
        return null;

    }

    @Override
    public String getName() {
        return stageName;
    }
}

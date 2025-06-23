package com.recceda.pipeline;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.recceda.model.WebEvent;

import lombok.Getter;
import lombok.Setter;

public class WebEventGeneralTreePipeline {

    @Getter
    private final List<PipelineStage<?, ?>> stages;
    @Setter
    private  List<WebEvent> webEvents;
    private static final Logger logger = Logger.getLogger(WebEventGeneralTreePipeline.class.getName());

    public WebEventGeneralTreePipeline(List<PipelineStage<?, ?>> stages) {
        this.stages = stages;
    }


    public void addStage(PipelineStage<?, ?> stage) {
        stages.add(stage);
    }

    public void removeStage(PipelineStage<?, ?> stage) {
        stages.remove(stage);
    }

    public void execute() {
        Object input = webEvents;

        for (PipelineStage<?, ?> stage : stages) {
            logger.log(Level.INFO, "Processing stage: {0}", stage.getName());
            input = stage.process(input);
            logger.log(Level.INFO, "Input for next stage: {0}", input);
        }
    }
}

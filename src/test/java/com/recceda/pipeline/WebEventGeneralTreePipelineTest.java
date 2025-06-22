package com.recceda.pipeline;

import com.recceda.model.WebEvent;
import com.recceda.pipeline.stages.BuildEventNodeStage;
import com.recceda.pipeline.stages.EventGroupingStage;
import com.recceda.pipeline.stages.LoadEventsStage;
import com.recceda.processor.MongoWebEventJsonProcessor;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.util.List;

public class WebEventGeneralTreePipelineTest extends TestCase {

    public void testExecute() throws Exception {
        MongoWebEventJsonProcessor processor = new MongoWebEventJsonProcessor();
        String filePath = "src/test/resources/webevents.json";
        String jsonInput = new String(Files.readAllBytes(java.nio.file.Paths.get(filePath)));
        List<WebEvent> events = processor.process(jsonInput);
        assertNotNull("Processed events should not be null", events);


        List<PipelineStage<?, ?>> stages = List.of(
                new LoadEventsStage(),
                new BuildEventNodeStage(),
                new EventGroupingStage()
        );

        WebEventGeneralTreePipeline pipeline = new WebEventGeneralTreePipeline(stages);
        pipeline.setWebEvents(events);
        pipeline.execute();
        assertNotNull("Pipeline should not be null", pipeline);
        assertEquals("Pipeline should have 2 stages", 3, pipeline.getStages().size());
        assertEquals("First stage should be LoadEventsStage", "LoadEventsStage", pipeline.getStages().get(0).getName());
        assertEquals("Second stage should be BuildEventNodeStage", "BuildEventNodeStage", pipeline.getStages().get(1).getName());


    }

}

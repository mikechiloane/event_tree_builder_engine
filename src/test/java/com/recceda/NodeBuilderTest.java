package com.recceda;

import com.recceda.model.EventNode;
import com.recceda.model.WebEvent;
import com.recceda.model.event.Batch;
import com.recceda.processor.MongoWebEventJsonProcessor;
import com.recceda.processor.MongoWebEventJsonProcessorTest;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class NodeGeneratorTest extends TestCase {

    public void testNodeBuilder() throws Exception {
        String filePath = "src/test/resources/webevents.json";
        String jsonInput = new String(Files.readAllBytes(java.nio.file.Paths.get(filePath)));
        List<WebEvent> webEvents = new MongoWebEventJsonProcessor().process(jsonInput);
        List<Batch> batches = new ArrayList<>();
        for(WebEvent webEvent : webEvents) {
            batches.addAll(webEvent.getBatch());
        }

        EventNode  node = NodeGenerator.buildNode(batches.get(0));

        }


    }

}
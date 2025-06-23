package com.recceda.processor;

import com.recceda.model.WebEvent;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.util.List;

public class MongoWebEventJsonProcessorTest extends TestCase {

    public void testProcess() {
        try {
            MongoWebEventJsonProcessor processor = new MongoWebEventJsonProcessor();
            String filePath = "src/test/resources/webevents.json";
            String jsonInput = new String(Files.readAllBytes(java.nio.file.Paths.get(filePath)));
            List<WebEvent> events = processor.process(jsonInput);
            assertNotNull("Processed events should not be null", events);
            assertTrue("Processing should succeed", events.size() ==4);
            events
                    .forEach(event -> {
                       assertNotNull("Event meta should not be null", event.getMeta());
                        assertNotNull("Event batch should not be null", event.getEvents());
                        assertNotNull("Event timestamp should not be null", event.getTimestamp());
                    });
        } catch (Exception e) {
            fail("Processing failed with exception: " + e.getMessage());
        }
       }



       public void testNumberOfBatches() {
           try {
               MongoWebEventJsonProcessor processor = new MongoWebEventJsonProcessor();
               String filePath = "src/test/resources/webevents.json";
               String jsonInput = new String(Files.readAllBytes(java.nio.file.Paths.get(filePath)));
               List<WebEvent> events = processor.process(jsonInput);
               long totalBatches = events.stream()
                       .mapToLong(event -> event.getEvents().size())
                       .sum();
               assertEquals("Total number of batches should be 16", 16, totalBatches);
           } catch (Exception e) {
               fail("Processing failed with exception: " + e.getMessage());
           }
       }

    public void testValidate() {
    }
}
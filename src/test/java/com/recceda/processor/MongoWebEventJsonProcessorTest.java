package com.recceda.processor;

import com.recceda.model.WebEvent;
import junit.framework.TestCase;

import java.nio.file.Files;
import java.util.List;

public class WebEventJsonProcessorTest extends TestCase {

    public void testProcess() {
        try {
            WebEventJsonProcessor processor = new WebEventJsonProcessor();
            String filePath = "src/test/resources/webevents.json"; // Adjust the path as needed
            String jsonInput = new String(Files.readAllBytes(java.nio.file.Paths.get(filePath)));
            // Process the JSON input
            System.out.println("Processing JSON input: " + jsonInput);
            List<WebEvent> events = processor.process(jsonInput);
            assertNotNull("Processed events should not be null", events);

            assertTrue("Processing should succeed", events.size() > 0);
        } catch (Exception e) {
            fail("Processing failed with exception: " + e.getMessage());
        }
       }

    public void testValidate() {
    }
}
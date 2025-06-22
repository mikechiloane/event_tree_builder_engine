package com.recceda;

import com.recceda.model.event.Event;
import com.recceda.model.event.Page;
import junit.framework.TestCase;

public class NodeBuilderTest extends TestCase {


    public void testLevelClassifier() throws Exception {
        Event testEvent = getTestEvent();
        int level = NodeBuilder.getLevel(testEvent);
        assertEquals("Level should be 0 for root path", 0, level);

        String eventPath = "/a/b/c";
        testEvent.getPage().setPath(eventPath);
        level = NodeBuilder.getLevel(testEvent);
        assertEquals("Level should be 3 for path /a/b/c", 2, level);
    }

    public Event getTestEvent() {
        Page page = new Page();
        page.setPath("/");
        Event event = new Event();
        event.setPage(page);
        return event;
    }


}
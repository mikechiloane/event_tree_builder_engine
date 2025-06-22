package com.recceda.processor;

import com.recceda.model.WebEvent;

import java.util.List;

public interface EventsInputProcessor {

    /**
     * processes json input and
     * returns a list of WebEvent objects
     * @param jsonInput the JSON input string
     * @return a list of WebEvent objects
     */
    List<WebEvent> process(String jsonInput) throws Exception;
    /**
     * Validates the JSON input string.
     *
     * @param jsonInput the JSON input string to validate
     * @return true if the JSON input is valid, false otherwise
     */
    boolean validate(String jsonInput) throws Exception;
}

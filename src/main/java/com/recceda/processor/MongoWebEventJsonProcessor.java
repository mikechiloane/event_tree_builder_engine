package com.recceda.processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.recceda.model.WebEvent;

import java.time.Instant;
import java.util.List;

public class WebEventJsonProcessor implements EventsInputProcessor {

    @Override
    public List<WebEvent> process(String jsonInput) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Instant.class, new MongoDateInstantDeserializer());
        objectMapper.registerModule(module);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(jsonInput, new TypeReference<List<WebEvent>>() {});
    }

    @Override
    public boolean validate(String jsonInput) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readValue(jsonInput, new TypeReference<List<WebEvent>>() {});
            return true;
        } catch (Exception e) {
             return false;
        }
    }
}

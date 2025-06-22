package com.recceda.webeventcollector.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Element {
    private String tag;
    private String id;
    private String classes;
    private String text;
    private Map<String, String> attributes;
}
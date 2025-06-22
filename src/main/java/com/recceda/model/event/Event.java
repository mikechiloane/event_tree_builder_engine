package com.recceda.model.event;

import com.recceda.model.WebEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Event {
    private String type;
    private String actionName;
    private Element element;
    private WebEvent event;
    private Page page;
    private String timestamp;
    private String userId;
    private String sessionId;
    private String deviceId;

}
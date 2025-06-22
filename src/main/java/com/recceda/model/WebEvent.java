package com.recceda.model.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.Instant;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class WebEvent {

    private String id;
    private Meta meta;
    private List<Batch> batch;
}

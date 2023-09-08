package com.cause.event.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyApplicationEvent {

    private String id;

    private String name;

}

// src/main/java/com/example/demo/dto/OpenMeteoCurrent.java
package com.example.demo.dto;

import lombok.Data;

@Data
public class OpenMeteoCurrent {
    private String time;
    private Integer interval;
    private Double temperature_2m;
    private Integer relative_humidity_2m;
    private Double apparent_temperature;
    private Integer weather_code;
}

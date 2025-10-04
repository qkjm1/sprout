// src/main/java/com/example/demo/dto/RegionWeatherDto.java
package com.example.demo.dto;

import lombok.Data;

@Data
public class RegionWeatherDto {
    // 지역
    private String addressName;
    private String sido;
    private String sigungu;
    private String dong;

    // 좌표
    private Double lat;
    private Double lon;

    // 날씨
    private Double temperature2m;
    private Integer humidity;
    private Double apparentTemperature;
    private Integer weatherCode;
}

package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DiaryWeather {
 private Long id;
 private int diary_id;
 private String weather; 
 private double temperature_c;
 private String location_name;
 private LocalDateTime createdAt;

}

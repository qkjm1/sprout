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
public class DiaryEntry {
 private Long id;
 private int usrId;
 private String title;
 private String content;
 private String mood;   //느낌
 private LocalDateTime createdAt;
 private LocalDateTime updatedAt; 
 private String weather;   // 날씨
 private double temperature_c;  // 온도섭씨
 
}

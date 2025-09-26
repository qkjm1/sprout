package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class RegionCodeRes {
  private List<Document> documents;
  @Data public static class Document {
    private String region_type;  // H=행정동 / B=법정동
    private String address_name; // "서울 중구 남대문로5가"
    private String region_1depth_name; // 시/도
    private String region_2depth_name; // 구/군
    private String region_3depth_name; // 동
  }
}
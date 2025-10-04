// src/main/java/com/example/demo/dto/RegionCodeRes.java
package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class RegionCodeRes {
    private List<Document> documents;

    @Data
    public static class Document {
        private String region_type;
        private String address_name;
        private String region_1depth_name;
        private String region_2depth_name;
        private String region_3depth_name;
        private String code;
        private double x; // lon
        private double y; // lat
    }
}

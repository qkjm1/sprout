// src/main/java/com/example/demo/controller/KakaoController.java
package com.example.demo.controller;

import com.example.demo.dto.RegionCodeRes;
import com.example.demo.dto.RegionWeatherDto;
import com.example.demo.service.KakaoService;
import com.example.demo.service.GeoWeatherService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;
    private final GeoWeatherService geoWeatherService;

    /** (A) 좌표 → 행정동 (카카오) */
    @GetMapping("/geo/reverse")
    public Mono<RegionCodeRes> reverse(@RequestParam double lat, @RequestParam double lon) {
        return kakaoService.coord2Region(lat, lon);
    }

    /** (B) 좌표 → 행정동 + 현재날씨 (카카오 + Open-Meteo) */
    @GetMapping("/weather")
    public Mono<RegionWeatherDto> weather(@RequestParam double lat, @RequestParam double lon) {
        return geoWeatherService.getRegionWithWeather(lat, lon);
    }
    
 // KakaoController 에 추가
    @GetMapping("/_debug/kakao-key")
    public Map<String, Object> debugKey(@Value("${app.kakao.rest-api-key:}") String key) {
        return Map.of(
            "present", key != null && !key.isBlank(),
            "len", key == null ? 0 : key.length(),
            "prefix", key == null ? "" : key.substring(0, Math.min(4, key.length())) + "****"
        );
    }

}

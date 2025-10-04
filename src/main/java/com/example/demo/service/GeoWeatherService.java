// src/main/java/com/example/demo/service/GeoWeatherService.java
package com.example.demo.service;

import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GeoWeatherService {

    private final KakaoService kakaoService;
    private final OpenMeteoService openMeteoService;

    /** 좌표 → (카카오)행정동 + (Open-Meteo)현재날씨 합본 */
    public Mono<RegionWeatherDto> getRegionWithWeather(double lat, double lon) {
        return Mono.zip(
                kakaoService.coord2Region(lat, lon),
                openMeteoService.getCurrent(lat, lon)
        ).map(tuple -> {
            RegionCodeRes region = tuple.getT1();
            OpenMeteoResp weather = tuple.getT2();

            RegionWeatherDto dto = new RegionWeatherDto();
            dto.setLat(lat);
            dto.setLon(lon);

            // 지역
            if (region != null && region.getDocuments() != null && !region.getDocuments().isEmpty()) {
                var h = region.getDocuments().stream()
                        .filter(d -> "H".equalsIgnoreCase(d.getRegion_type())) // 행정동 우선
                        .findFirst()
                        .orElse(region.getDocuments().get(0));
                dto.setAddressName(h.getAddress_name());
                dto.setSido(h.getRegion_1depth_name());
                dto.setSigungu(h.getRegion_2depth_name());
                dto.setDong(h.getRegion_3depth_name());
            }

            // 날씨
            if (weather != null && weather.getCurrent() != null) {
                var c = weather.getCurrent();
                dto.setTemperature2m(c.getTemperature_2m());
                dto.setHumidity(c.getRelative_humidity_2m());
                dto.setApparentTemperature(c.getApparent_temperature());
                dto.setWeatherCode(c.getWeather_code());
            }

            return dto;
        });
    }
}

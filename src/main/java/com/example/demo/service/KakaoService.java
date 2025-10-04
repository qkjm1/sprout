// src/main/java/com/example/demo/service/KakaoService.java
package com.example.demo.service;

import com.example.demo.dto.RegionCodeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final WebClient kakaoWebClient;

    @Value("${app.kakao.rest-api-key}")
    private String kakaoKey;

    /** 좌표 → 행정동(역지오코딩) */
    public Mono<RegionCodeRes> coord2Region(double lat, double lon) {
        return kakaoWebClient.get()
                .uri(uri -> uri.path("/v2/local/geo/coord2regioncode.json")
                        .queryParam("x", lon)
                        .queryParam("y", lat)
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoKey)
                .retrieve()
                .bodyToMono(RegionCodeRes.class);
    }
}

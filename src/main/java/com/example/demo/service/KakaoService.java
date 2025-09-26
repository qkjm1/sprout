package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.RegionCodeRes;

import reactor.core.publisher.Mono;

@Service
public class KakaoService {

	private final WebClient kakaoWebClient;

    // WebClientConfig 의 @Bean 이름과 동일하게 주입
    public KakaoService(WebClient kakaoWebClient) {
        this.kakaoWebClient = kakaoWebClient;
    }

    public Mono<RegionCodeRes> coord2region(double lon, double lat) {
        // 예시 호출 형태 (카카오 Local 좌표->행정구역 API 스펙에 맞춰 경로/쿼리 변경)
        return kakaoWebClient.get()
                .uri(uri -> uri.path("/v2/local/geo/coord2regioncode.json")
                               .queryParam("x", lon)
                               .queryParam("y", lat)
                               .build())
                .retrieve()
                .bodyToMono(RegionCodeRes.class);
    }

}

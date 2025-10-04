// src/main/java/com/example/demo/service/OpenMeteoService.java
package com.example.demo.service;

import com.example.demo.dto.OpenMeteoResp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OpenMeteoService {

    private final WebClient openMeteoWebClient;

    @Value("${app.openmeteo.timezone:Asia/Seoul}")
    private String timezone;

    public Mono<OpenMeteoResp> getCurrent(double lat, double lon) {
        return openMeteoWebClient.get()
                .uri(uri -> uri.path("/v1/forecast")
                        .queryParam("latitude", lat)
                        .queryParam("longitude", lon)
                        .queryParam("current", "temperature_2m,relative_humidity_2m,apparent_temperature,weather_code")
                        .queryParam("timezone", timezone)
                        .build())
                .retrieve()
                .bodyToMono(OpenMeteoResp.class);
    }
}

package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeDto {
	// 응답 DTO
	public record DiaryRes(
	  Long id, int usrId, String title, String content, String mood,
	  String createdAt, String updatedAt, String weather,
	  @JsonProperty("temperature_c") Double temperatureC
	) {}

	// 생성/수정 요청 DTO
	public record DiaryReq(
	  String title, String content, String mood
	  // usrId는 세션에서, weather/temperature_c는 서버에서 채우면 제외
	) {}

}

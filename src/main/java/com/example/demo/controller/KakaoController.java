package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.dto.RegionCodeRes;
import com.example.demo.service.KakaoService;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/diary")
public class KakaoController {

	@Autowired
	private KakaoService kakaoService;

	@GetMapping("/coord2region")
	public Mono<RegionCodeRes> coord2region(@RequestParam double lat, @RequestParam double lon) {
		return kakaoService.coord2region(lon, lat);
	}

}
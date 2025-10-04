package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.DiaryService;
import com.example.demo.vo.DiaryEntry;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@GetMapping("/")
	@ResponseBody
	public String ShowDiary() {
		return "ok";
	}

	// 다이어리 추가 (	날씨 + 내용 )
	@PostMapping("/add")
	public ResponseEntity<?> addDiary(@RequestBody DiaryEntry e) {
		long e_Id = diaryService.AddDiaryEntry(e);	
		
		return ResponseEntity.ok(e_Id);
	}

	// 유저 id 기준으로 다이어리 리스트를 가지고올건데 limit걸어서
	@GetMapping("/list")
	@ResponseBody
	public List<DiaryEntry> DiaryAllList(int id, @RequestParam(defaultValue = "1") int page) {
		// 해당 유저인지 확인

		int listInApage = 10;
		/*
		 * 유저 기준으로다이어리가지고오기 다이어리가 없을 경우 글이 존재하지않음 한 페이지에 10개씩 보여주기 무한리스트하기 날짜별로 묶기 카테고리
		 */
		List<DiaryEntry> allDaisrybyPage = diaryService.AllbyId(id, listInApage, page);

		// 년/월/주 로 리스트 가져오기
		List<DiaryEntry> allDaisrybyDate = diaryService.AllbyId(id, listInApage, page);

		// page 없이 전체리스트 가지고오기(따로 뺄 예정)
		List<DiaryEntry> allDaisryList = diaryService.AllbyId(id, listInApage, page);

		return allDaisrybyPage;
	}

}
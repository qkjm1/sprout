package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DiaryRepository;
import com.example.demo.vo.DiaryEntry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;

	public List<DiaryEntry> AllbyId(int id, int listInApage, int page) {
		int limitTake = listInApage;
		int limitForm = (page - 1) * listInApage;

		return diaryRepository.AllbyId(id, limitTake, limitForm);
	}

	public long AddDiaryEntry(DiaryEntry e) {
		diaryRepository.AddDiaryEntry(e);
		return e.getId();
	}
	
}

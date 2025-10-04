package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.DiaryEntry;

@Mapper
public interface DiaryRepository {
	
	// 다이어리 저장 단건저장
	long AddDiaryEntry(@Param("e") DiaryEntry e);
	// id 기준으로 일기 저장 데이터 가지고오기 (list)
	List<DiaryEntry> AllbyId(int id, int limitTake, int limitForm);

	
}
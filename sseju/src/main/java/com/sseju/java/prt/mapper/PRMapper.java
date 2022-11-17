package com.sseju.java.prt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.prt.service.PRVO;
@Mapper
public interface PRMapper {

	// 전체
	public List<PRVO> selectPrtList();

	// 단건
	public PRVO selectPrtInfo(PRVO Ovo);

	// 등록
	public int insertPrtInfo(PRVO Ovo);

	
}

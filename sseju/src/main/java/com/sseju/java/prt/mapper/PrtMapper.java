package com.sseju.java.prt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.prt.service.PrtVO;
@Mapper
public interface PrtMapper {

	// 전체
	public List<PrtVO> selectPrtList();

	// 단건
	public PrtVO selectPrtInfo(PrtVO Ovo);

	// 등록
	public int insertPrtInfo(PrtVO Ovo);

	
}

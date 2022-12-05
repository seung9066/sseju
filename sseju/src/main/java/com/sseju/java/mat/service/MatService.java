package com.sseju.java.mat.service;

import java.util.List;
import java.util.Map;

public interface MatService {

	//material 기본자재리스트
	public List<MatVO> material();
	//발주 전체 조회
	public List<MatVO> matordList();
	
	//입고 전체 조회
	public List<MatVO> matInList();
	
	//출고 전체 조회
	public List<MatVO> matOutList();
	
	//재고 전체 조회
	public List<MatVO> matStockList();
	
	//검수 내역 전체 조회
	public List<MatVO> matCheckList();
	
	//내역 내용 등록
	public int docUpdate(MatVO MatVO);
}

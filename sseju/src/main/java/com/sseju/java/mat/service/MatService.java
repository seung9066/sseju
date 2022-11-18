package com.sseju.java.mat.service;

import java.util.List;
import java.util.Map;

public interface MatService {

	//발주 전체 조회
	public List<MatVO> matBuyList();
	//발주 단건 조회
	public MatVO selectMatbuyInfo(MatVO MatVO);
	//발주 등록
	public int insertMatbuy(MatVO MatVO);
	//발주 수정
	public int updateMatbuy(MatVO MatVO);
	//발주 삭제
	public int deleteMatbuy(MatVO MatVO);
	public int selectDelete(List<String> list);
	
	//입고 전체 조회
	public List<MatVO> matInList();
	//입고 단건 조회
	public MatVO selectMatIn(MatVO MatVO);
	//입고 등록
	public int insertMat(MatVO MatVO);
	//입고 수정
	public int updateMat(MatVO MatVO);
	//입고 삭제
	public int deleteMat(MatVO MatVO);
	public int selectDeleteMatIn(MatVO MatVO);
	
	//출고 전체 조회
	public List<MatVO> matOutList();
	//출고 단건 조회
	public MatVO selectMatOut(MatVO MatVO);
	//출고 등록
	public int insertMatOut(MatVO MatVO);
	//출고 수정
	public int updateMatOut(MatVO MatVO);
	//출고 삭제
	public int deleteMatOut(MatVO MatVO);
	public int selectDeleteMatOut(MatVO MatVO);
	
	//재고 전체 조회
	public List<MatVO> matStockList();
	//재고 단건 조회
	public MatVO selectMatStock(MatVO MatVO);
	//재고 등록
	public int insertMatStock(MatVO MatVO);
	//재고 수정
	public int updateMatStock(MatVO MatVO);
	//재고 삭제
	public int deleteMatStock(MatVO MatVO);
	public int selectDeleteMatStock(List<String> list);
	
	//검수 내역 전체 조회
	public List<MatVO> matCheckList();
	//검수 단건 조회
	public MatVO selectMatCheck(MatVO MatVO);
	//검수 등록
	public int insertMatCheck(MatVO MatVO);
	//검수 수정
	public int updateMatCheck(MatVO MatVO);
	//검수 삭제
	public int deleteMatCheck(MatVO MatVO);
	public int selectDeleteMatCheck(List<String> list);
}

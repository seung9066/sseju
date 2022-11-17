package com.sseju.java.mat.service;

import java.util.List;

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
}

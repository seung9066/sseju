package com.sseju.java.matroder.service;

import java.util.List;

public interface MatOrderService {
	//자재 발주 등록
	public int insertMatOrder(MatOrderVO moVO);
	//자재 발주 전체 조회
	public List<MatOrderVO> getMatOrderList();
	//자재 발주 단건조회
	public MatOrderVO getSearchMatOrder();
	//자재 발주 신청 수정
	public int updateMatOrder(MatOrderVO maVO);
	//자재 발주 삭제
	public int deleteMatOrder(MatOrderVO maVO);
}

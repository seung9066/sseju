package com.sseju.java.matroder.mapper;

import java.util.List;

import com.sseju.java.matroder.service.MatOrderVO;

public interface MatOrderMapper {
	//자재 발주 CRUD, 생산관리 - 생산 진행 현황 페이지 내에서 사용할 자재발주
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

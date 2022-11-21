package com.sseju.java.matrecchk.mapper;

import java.util.List;

import com.sseju.java.matrecchk.service.MatRecChkVO;

//수입검사 페이지 매퍼
public interface MatRecChkMapper {
	//C 자재 수입 검사 등록
	public int insertMatRecChk(MatRecChkVO mrcVO);
	//R 자재 수입 검사 전체 조회
	public List<MatRecChkVO> getMatRecChkList();
	//수입 검사 단건(검색)조회
	public MatRecChkVO getMatRecChkInfo(MatRecChkVO mrcVO);
	//U수정
	public int updateMatRecChk(MatRecChkVO mrcVO);
	//D삭제
	public int deleteMatRecChk(MatRecChkVO mrcVO);
}

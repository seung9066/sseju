package com.sseju.java.company.service;

import java.util.List;

public interface CompanyService {
	// 회원 전체 조회
	public List<CompanyVO> getCompanyList();

	// 회원 단건 조회
	public CompanyVO getCompanyInfo(CompanyVO vo);

	// 회원 가입
	public int insertCompany(CompanyVO vo);

	// 회원 수정
	public int updateCompany(CompanyVO vo);

	// 회원 삭제
	public int deleteCompany(CompanyVO vo);
}

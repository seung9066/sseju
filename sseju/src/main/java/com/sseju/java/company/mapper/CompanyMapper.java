package com.sseju.java.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.company.service.CompanyVO;

@Mapper
public interface CompanyMapper {
		
		// 코드 조회
		public String companyCode(CompanyVO vo);
	
		// 회원 전체 조회
		public List<CompanyVO> getCompanyList();

		// 회원 단건 조회
		public CompanyVO getCompanyInfo(CompanyVO vo);
		// 회원 로그인용 조회
		public CompanyVO getCompanyInfoId(CompanyVO vo);

		// 회원 가입
		public int insertCompany(CompanyVO vo);
		public int insertLogin(CompanyVO vo);

		// 회원 수정
		public int updateCompany(CompanyVO vo);

		// 회원 삭제
		public int deleteCompany(CompanyVO vo);
		public int deleteLogin(CompanyVO vo);
}

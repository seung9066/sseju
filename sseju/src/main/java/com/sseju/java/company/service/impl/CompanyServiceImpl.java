package com.sseju.java.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.company.mapper.CompanyMapper;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyMapper mapper;
	
	@Override
	public List<CompanyVO> getCompanyList() {
		// TODO Auto-generated method stub
		return mapper.getCompanyList();
	}

	@Override
	public CompanyVO getCompanyInfo(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.getCompanyInfo(vo);
	}

	@Override
	public int insertCompany(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertCompany(vo);
	}

	@Override
	public int updateCompany(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateCompany(vo);
	}

	@Override
	public int deleteCompany(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteCompany(vo);
	}

	@Override
	public String companyCode(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.companyCode(vo);
	}

	@Override
	public int insertLogin(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertLogin(vo);
	}

	@Override
	public CompanyVO getCompanyInfoId(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.getCompanyInfoId(vo);
	}

	@Override
	public int deleteLogin(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteLogin(vo);
	}

}

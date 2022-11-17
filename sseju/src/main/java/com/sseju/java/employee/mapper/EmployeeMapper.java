package com.sseju.java.employee.mapper;

import java.util.List;

import com.sseju.java.employee.service.EmployeeVO;

public interface EmployeeMapper {
	// 회원 전체 조회
	public List<EmployeeVO> getEmpList();

	// 회원 단건 조회
	public EmployeeVO getEmpInfo(EmployeeVO vo);

	// 회원 가입
	public int insertEmp(EmployeeVO vo);

	// 회원 수정
	public int updateEmp(EmployeeVO vo);

	// 회원 삭제
	public int deleteEmp(EmployeeVO vo);
	
	public int idCheck(String id);
	
	public int deleteLogin(EmployeeVO vo);
}

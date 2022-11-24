
package com.sseju.java.employee.service;

import java.util.List;

public interface EmployeeService {
	// 회원 전체 조회
	public List<EmployeeVO> getEmpList();

	// 회원 단건 조회
	public EmployeeVO getEmpInfo(EmployeeVO vo);
	
	// id ckeck
	public int idCheck(String id);

	// 회원 가입
	public int insertEmp(EmployeeVO vo);

	// 회원 수정
	public int updateEmp(EmployeeVO vo);

	// 회원 삭제
	public int deleteEmp(EmployeeVO vo);
	
	public int deleteLogin(EmployeeVO vo);
}

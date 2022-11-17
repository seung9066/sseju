package com.sseju.java.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.employee.mapper.EmployeeMapper;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeMapper mapper;

	@Override
	public List<EmployeeVO> getEmpList() {
		
		return mapper.getEmpList();
	}

	@Override
	public EmployeeVO getEmpInfo(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getEmpInfo(vo);
	}

	@Override
	public int insertEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertEmp(vo);
	}

	@Override
	public int updateEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteEmp(vo);
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return mapper.idCheck(id);
	}

	@Override
	public int deleteLogin(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteLogin(vo);
	}
	
	
}

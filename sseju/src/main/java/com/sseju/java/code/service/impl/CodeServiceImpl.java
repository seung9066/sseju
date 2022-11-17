package com.sseju.java.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.code.mapper.CodeMapper;
import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;

@Service
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	CodeMapper mapper;
	
	@Override
	public List<CodeVO> getCodeList() {
		// TODO Auto-generated method stub
		return mapper.getCodeList();
	}

	@Override
	public CodeVO getCodeInfo(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getCodeInfo(vo);
	}

	@Override
	public int insertCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertCode(vo);
	}

	@Override
	public int updateCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateCode(vo);
	}

	@Override
	public int deleteCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteCode(vo);
	}

	@Override
	public int selectDelete(List<String> list) {
		// TODO Auto-generated method stub
		return mapper.selectDelete(list);
	}

	@Override
	public List<CodeVO> getBomList(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getBomList(vo);
	}

	@Override
	public List<CodeVO> getBomMenu() {
		// TODO Auto-generated method stub
		return mapper.getBomMenu();
	}

}

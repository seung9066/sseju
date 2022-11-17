package com.sseju.java.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.code.service.CodeVO;

@Mapper
public interface CodeMapper {

	public List<CodeVO> getCodeList();
	public CodeVO getCodeInfo(CodeVO vo);
	public int insertCode(CodeVO vo);
	public int updateCode(CodeVO vo);
	public int deleteCode(CodeVO vo);
	public int selectDelete(List<String> list);
	
	// bom
	public List<CodeVO> getBomList(CodeVO vo);
	public List<CodeVO> getBomMenu();
	
}

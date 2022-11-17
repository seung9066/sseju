package com.sseju.java.code.service;

import java.util.List;

public interface CodeService {

	public List<CodeVO> getCodeList();
	public CodeVO getCodeInfo(CodeVO vo);
	public int insertCode(CodeVO vo);
	public int updateCode(CodeVO vo);
	public int deleteCode(CodeVO vo);
	public int selectDelete(List<String> list);
	
	// bom
	public List<CodeVO> getBomList(CodeVO vo);
	public List<CodeVO> getBomMenu();
	public List<CodeVO> getBOMMatList();
	public CodeVO getPrtCode(CodeVO vo);
	public CodeVO getMatCode(CodeVO vo);
	public int insertBOM(CodeVO vo);
	public List<CodeVO> getBOMPrtList();
}

package com.sseju.java.eqm.service;

import java.util.List;

import com.sseju.java.code.service.CodeVO;

public interface EqmService {
   // 설비 전체조회
    public List<EqmVO> selectEqmList();
    
    // 설비 단건조회
    public EqmVO getEqmInfo(EqmVO eqmVO);
    
    // 설비 등록
    public int insertEqm(EqmVO eqmVO);
    
    // 설비 수정
    public int updateEqmInfo(EqmVO eqmVO);
    
    // 설비 삭제
    public int deleteEqm(List<String> deleteEqm);
    
   /*
    * // 거래처 company public List<CompanyVㄴO> getCompanyList();
    */
    
    // 직원 가져오기
    public List<EqmVO> getEmpList();


    // 라인 정보 전체조회
    public List<EqmVO> getEqmLineList();
    
    // 라인 정보 단건조회
    public EqmVO getEqmLineInfo(EqmVO eqmVO);

    // 라인정보 등록
    public int insertEqmLine(EqmVO eqmVO);

    // 라인정보 수정
    public int updateEqmLine(EqmVO eqmVO);

    // 라인정보 삭제
    public int deleteEqmLine(EqmVO eqmVO);
    
 // 라인에 종속된 설비 찾기
    public String eqmLineEx(EqmVO eqmVO);
    
    // 정기점검 전체조회
    public List<EqmVO> getEqmChkList();
    
    //정기점검 모달 가져오기
    public List<EqmVO> getChkList();
    
    // 정기점검 등록
    public int insertEqmChk(EqmVO eqmVO);
    
    // 정기점검 수정
    public int updateEqmChk(EqmVO eqmVO);

    // 정기점검 삭제
    public int deleteEqmChk(EqmVO eqmVO);
    
    // 비가동 전체조회
    public List<EqmVO> getUoperList();
    
    // 비가동코드만 불러오기
    public List<CodeVO> getUoperCode();
    	
    // 비가동 등록
    public int insertUoper(EqmVO eqmVO);
    // 비가동 삭제
    public int deleteUoper(List<String> deleteUoper);
    
    //비가동 수정
    public int updateUoper(EqmVO eqmVO);
    
   
    
	public int deleteLine(List<String> line);
	
	public int deleteChk(List<String> deleteChk);
	

	
	//비가동시 설비상태 yn
	public int updateEqmYn(EqmVO eqmVO);
	
	  // 비가동 공통코드
    public int updateUoprCd(CodeVO vo);

	
}
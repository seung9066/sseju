package com.sseju.java.eqm.service;

import java.util.List;

public interface EqmService {
	// 설비 전체조회
    public List<EqmVO> selectEqmList();
    
    // 설비 단건조회
    public EqmVO getEqmInfo(EqmVO eqmVO);
    
    // 설비 등록
    public int insertEqmInfo(EqmVO eqmVO);
    
    // 설비 수정
    public int updateEqmInfo(EqmVO eqmVO);
    
    // 설비 삭제
    public int deleteEqmInfo(EqmVO eqmVO);


    // 라인 정보 전체조회
    public List<EqmVO> getEqmLineList();
    
    // 라인 정보 단건조회
    public EqmVO getEqmLineInfo(EqmVO eqmVO);

    // 라인정보 등록
    public int insertEqmLine(EqmVO eqmVO);

    // 라인정보 수정
    public int updateEqmLine(EqmVO eqmVO);

    // 라인정보 삭제
    public int deleteEqmLine(String lineNo);
    
    
    // 정기점검 전체조회
    public List<EqmVO> getEqmChkList();
    
    //정기점검 단건조회
    public EqmVO getEqmChkInfo(EqmVO eqmVO);
    
    // 정기점검 등록
    public int insertEqmChk(EqmVO eqmVO);
    
    // 정기점검 수정
    public int updateEqmChk(EqmVO eqmVO);

    // 정기점검 삭제
    public int deleteEqmChk(EqmVO eqmVO);
}

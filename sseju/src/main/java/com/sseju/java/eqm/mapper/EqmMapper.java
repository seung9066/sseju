package com.sseju.java.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.eqm.service.EqmVO;

@Mapper
public interface EqmMapper {
      // 설비 전체조회
      public List<EqmVO> selectEqmList();

      // 설비 등록
      public int insertEqmInfo(EqmVO eqmVO);
      
      // 설비 수정
      public int updateEqmInfo(EqmVO eqmVO);
      
      // 설비 삭제
      public int deleteEqmInfo(EqmVO eqmVO);


      // 라인 정보 전체조회
      public List<EqmVO> getEqmLineList();

      // 라인정보 등록
      public int insertEqmLine(EqmVO eqmVO);

      // 라인정보 수정
      public int updateEqmLine(EqmVO eqmVO);

      // 라인정보 삭제
      public int deleteEqmLine(String lineNo);
      
      
      // 정기점검 전체조회
      public List<EqmVO> getEqmChkList();
      
      // 정기점검 등록
      public int insertEqmChk(EqmVO eqmVO);
      
      // 정기점검 수정
      public int updateEqmChk(EqmVO eqmVO);

      // 정기점검 삭제
      public int deleteEqmChk(EqmVO eqmVO);
}
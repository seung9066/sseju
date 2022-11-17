package com.sseju.java.eqm.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("EqmVO")
public class EqmVO {
   //설비
   private String eqmCode;
   private String eqmName;
   private String eqmModel;
   private String eqmSize;
   private String eqmLoc;
   private int eqmMaxTemp;
   private int eqmMinTemp;
   private String eqmCheck;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date eqmPurcDate;
   private String eqmDiv;
   private String eqmImg;
   private String eqmPurcName;
   private String eqmPurcTel;
   private String eqmYn;
   
   // 라인
   private String lineNo; // 라인 번호
   private int totPrc; // 총생산량
   private int uph; //UPH
   private String empNo; //담당자
   private String lineYn; // 사용여부
   
   //정기점검
   private String chkNo; //정기점검 이력번호
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date chkDate; // 점검일자
   private Date chkNdate; // 차기 점검일자
   private String chkState; //판정
   private String chkSol; //조치사항
   private String chkEmpNo; //점검담당자

}
package com.sseju.java.eqm.service;





import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
   private int eqmCheck; //점검일수 숫자
   private String eqmCheckTerm; // 점검 '주기' 
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date eqmPurcDate;
   String eqmImg;
   private String eqmPurcName;
   private String eqmPurcTel;
   private String eqmYn;
   
   
     //거래처
   private String cpCode; 
   private String cpName;
   private String cpTel;
   
   //
   private String code; 
   private String divName;
   private String codeName;
   private String divCode;

   
   // 직원
   private String empId;
   private String empName;
   private String empDept;
    
   
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
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date chkNdate; // 차기 점검일자
   private String chkState; //판정
   private String chkSol; //조치사항
   private String chkEmpNo; //점검담당자
   
   //비가동
   private String uoperCode; // 비가동이력번호
   private String uoperEmpNo; //담당자
   private String uoperRsn; // 비가동사유
   private String uoperWork; //작업내용
   private String uoperStartTime; //비가동 시작시간
   private String uoperEndTime; // 재가동 시간
   private String uoperRsnCode; // 비가동사유 코드
   
   

}
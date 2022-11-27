package com.sseju.java.processcheck.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
//공정 검사 조회/관리 페이지용 VO
@Data
@Alias("pcVO")
public class ProcessCheckVO {
	//process_inf테이블
	private String prsNo;		//작업번호
	private int prsOutput;		//생산량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsStHour;		//작업 시작 시간
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsSpHour;		//작업 종료시간
	
	//process_err 테이블
	private Integer prsErrQty;	//불량수량 
	private String prsPfNo;		//실적번호  FK, prs_inf의 pk
	
	private String errCode;		//불량 코드 FK, error테이블의 PK
	//error테이블
	private String errName;		//불량명
	private String errOption;	//불량 구분
	private String code;		//자재/공정 코드
	private String errPct;		//불량률
	
	//process_run 테이블
	private String prsDate;		//작업일자
	
	//process 테이블
	private String prsCode;		//공정코드 
	private String prsName;		//공정명	 process tbl
	private String prsManager;	//공정 검사 담당자 process_run tbl, emp테이블에서 id끌어와서 써야함
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	//produce테이블
	private String preNo;		//작업 지시 번호를 받아서 조회할것
	
	//employee 테이블
	private String empName;		//담당자명 가져오기
	private String empId;		
	
}

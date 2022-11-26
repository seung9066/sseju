package com.sseju.java.workhistory.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("whVO")
public class WorkHistoryVO {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsDate;		//작업일자
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date prsStHour;		//작업 시작 시간
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date prsSpHour;		//작업 종료 시간
	private String prsManager;	//담당자명(empId가 담겨있음)
	private String empName;		//emp테이블의 사원명
	private String empId;		//emp 테이블의 직원아이디, prsManager와 비교하기위해서
	private Integer prsOutput;	//생산량, 공정이 진행되는 시간동안 발생한 총 생산량
	private Integer prsErrQty;	//불량수량, 공정 진행 시간간 발생 총 불량수 process_inf테이블
	private String errCode;		//불량코드
	
	private String prsCode;		//공정코드
	private String prsName;		//공정명
	
	private String errName;		//불량명
	private String errPct;		//불량률
	
	private String prsPfNo;		//실적번호
	
	private String prsNo;		//작업번호
	
}

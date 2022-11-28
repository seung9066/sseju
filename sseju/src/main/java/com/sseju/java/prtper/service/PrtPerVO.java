package com.sseju.java.prtper.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("ppVO")
public class PrtPerVO {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsDate;		//작업일자(기간별 조회할때 사용하고싶음) 
	private String prtCode;		//제품코드
	private String preNo;		//작업 지시 번호O --생산 실적
	private String prtName;		//제품명 O --생산 실적 
	private int insQty;			//지시수량(목표 생산량) 
	private int preQty;			//생산수량(실제 생산량) O 생산 실적
	private int prsErrQty;	 	//불량수량(process_inf테이블에서 가져와야함)O 생산 실적 및 불량 상세
	private String preManager;	//담당자명O --생산 실적
	private String empId;		// empid로 premanager와 값 비교해서 이름 가져와야함
	private String empName;		//담당자 명 불러오
	private String errCode;		//불량코드O --불량 상세
	private String errName;		//불량명O --불량 상세
	private int orderNo;		//주문번호
	private int prtQty;			//prr테이블의 생산량
	private String prrManager;	//prr테이블의 담당자
}

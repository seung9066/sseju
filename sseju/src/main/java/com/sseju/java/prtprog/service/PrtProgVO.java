package com.sseju.java.prtprog.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("pprVO")
public class PrtProgVO {
	//생산 진행 현황 페이지에 사용할 VO
	private String preNo;	//작업지시번호 produce_inf테이블 1
	private String prtName;	//제품명, product테이블에서 끌어와야함2
	private String prtCode; //제품코드
	private int preQty;		//생산된 수량 produce 테이블3
	private int prtQty; //생산수량
	private int insQty;		//지시수량 "4
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date preDate;	//작업 지시 일자5
	private String preManager;//작업 지시 담당자6 = 실제로는 emp_id값이 담겨있음
	private String empId;	//회원 아이디, 아래에empId있으므로 조인사용 필요 <-안쓸것같음
	private String empName;	//회원 이름 가져오기, 담긴 empid값으로 가져와야함
	private String lotQty;	
	private String matCode;	//자재코드
	private String matName;	//자재명
	private String matOutQty;//재고량(출고수량(자재수량))
}

package com.sseju.java.workorder.serivce;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("woVO")
public class WorkOrderVO {
	private String preNo; 		//작업 지시 번호 PK
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String preManager; 	//작업 담당자
	private String empName;		//직원이름
	private String empId;		//직원 아이디, 담당자 명을 가져오기 위해서
	private int insQty;			//지시 수량
	private String preQty;		//생산수량
	private String prtCode;		//제품코드 FK, 제품명 끌어오기도 필요함
	private String prtName;		//품목명
	private String orderNo;		//주문번호 FK, 서브쿼리나 조인문으로 업체명 가져와야함
	private String orderQty;	//주문수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;		//주문일자
	private String prePrg;		//작업 진행 상태(진행전, 진행중, 완료)표기용
	
}

package com.sseju.java.order.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ORVO")
public class ORVO {
	
	
	// 주문상세 데이터
	private String orderNo; 	//주문번호
	private String orderDate;		//주문일자
	private String prtName;		// 제품명
	private String dday; 			// 납기일자
	private int orderQty; 		//주문량
	private String orderPrg;	//진행상태
		
	private String cpCode; //업체코드
	private String cpName; //업체코드
	private String orderYn; // 승인여부
	private String prtUnit; // 단위
	
	//orderinf 테이블
	private int preNo; //생산번호
	private int orderOutQty; // 출고량
	private String preCode; //제품코드
	private int unitPrice; //주문단가
	private int orderPrice; //금액
	
	
	
	
	
	
}

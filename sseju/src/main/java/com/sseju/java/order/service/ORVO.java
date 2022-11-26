package com.sseju.java.order.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("ORVO")
public class ORVO {

	// 주문상세 데이터
	private String orderNo; // 주문번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate; // 주문일자
	private String prtName; // 제품명
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dday; // 납기일자
	private int orderQty; // 주문량
	private String orderPrg; // 진행상태

	private String cpCode; // 업체코드
	private String cpName; // 업체이름
	private String orderYn; // 승인여부
	private String prtUnit; // 단위

	// orderinf 테이블
	private String preNo; // 생산번호
	private int orderOutQty; // 출고량
	private String preCode; // 제품코드
	private int unitPrice; // 주문단가
	private int orderPrice; // 금액

	private int lotQty; // 생산수량(로트번호가 부여된 제품 단위의 총 개수)
	private String prtCode;
	private String lotNo;	//로트번호(시리얼번호) lot

//	
}

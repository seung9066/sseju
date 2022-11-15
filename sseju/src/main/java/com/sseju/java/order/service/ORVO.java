package com.sseju.java.order.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("ORVO")
public class ORVO {
	private int orderNo; //주문번호
	private Date dDay; // 납기일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String orderPrg;//진행상태
	private Date orderDate;//주문일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String cpCode; //업체코드
	private String orderYn; // 승인여부
	private int preNo; //생산번호
	private int orderQty; //주문량
	private int orderOutQty; // 출고량
	private String preCode; //제품코드
	private int unitPrice; //주문단가
	private int orderPrice; //금액
}

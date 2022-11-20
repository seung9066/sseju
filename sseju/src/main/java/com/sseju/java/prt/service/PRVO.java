package com.sseju.java.prt.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("PRVO")
public class PRVO {
	// 제품
	private String prtCode;
	private String prtName;
	private String prtStandard;
	private String prtUnit;
	private String prtPrice;
	private String cpName;
	
	
	
	
	
	
	
	
	
	private String prtImage;

	private String orderNo; // 주문번호
	private String orderDate; // 주문일자

	private int orderOutQty; // 출고량

	

}

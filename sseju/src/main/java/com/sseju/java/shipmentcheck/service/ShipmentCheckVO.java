package com.sseju.java.shipmentcheck.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//출하 검사 조회/관리 페이지용 VO
@Data
@Alias("scVO")
public class ShipmentCheckVO {
	private int prtOutNo;		//출하번호product_out tbl
	private int orderNo;		//주문번호 product_out FK, orders pk
	private String prtName;		//제품명 orders, orders_inf, product join 필요
	private int prtOutQty;		//완제품 출고 수량 product_out tbl
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prtOutDate;	//출하일자, product_out tbl
	private String del;			//배송상태, product_out tbl
	private String whCode;		//창고코드, product_out tbl
}

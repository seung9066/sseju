package com.sseju.java.workhistory.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("whVO")
public class WorkHistoryVO {
	private String preNo;	//작업 지시 번호
	private String prtCode;	//제품 코드
	private String prtName;	//제품명
	private int preQty;//생산량
	private String prManager;//담당자
}

package com.sseju.java.eqmLine.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EqmLineVO")
public class EqmLineVO {
	private String lineNo; // 라인 번호
	private int totPrc; // 총생산량
	private int uph; //UPH
	private String empNo; //담당자
	private String lineYn; // 사용여부

}

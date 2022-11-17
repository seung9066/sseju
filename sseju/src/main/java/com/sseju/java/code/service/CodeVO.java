package com.sseju.java.code.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CodeVO")
public class CodeVO {
	
	// code
	private String code;
	private String divName;
	private String codeName;
	private String divCode;
	
	// bom
	private String prtCode;
	private String capacity;
	private String matCode;
	private String prtName;
	private String matName;
}

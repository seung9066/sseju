package com.sseju.java.code.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CodeVO")
public class CodeVO {
	private String code;
	private String divName;
	private String codeName;
	private String divCode;
}

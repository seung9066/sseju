package com.sseju.java.prt.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("PRVO")
public class PRVO {
	private String prtCode;
	private String prtName;
	private String prtStandard;
	private String prtUnit;
	private int prtPrice;
	private String prtImage;
	
}

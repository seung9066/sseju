package com.sseju.java.prt.service;

import lombok.Data;

@Data
public class PrtVO {
	private String prtCode;
	private String prtName;
	private String prtStandard;
	private String prtUnit;
	private int prtPrice;
	private String prtImage;
}

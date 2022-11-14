package com.sseju.java.eqm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EqmVO {
	private String eqmCode;
	private String eqmName;
	private String eqmModel;
	private String eqmSize;
	private String eqmLoc;
	private int eqmMaxTemp;
	private int eqmMinTemp;
	private String eqmCheck;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eqmPurcDate;
	private String eqmDiv;
	private String eqmImg;
	private String eqmPurcName;
	private String eqmPurcTel;
	private String eqmYn;
	private String lineNo;

}

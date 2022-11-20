package com.sseju.java.code.service;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("CodeVO")
public class CodeVO {
	
	private String CpName;
	
	// code
	private String code;
	private String divName;
	private String codeName;
	private String divCode;
	
	// employee
	private String empId;
	private String empName;
	
	// bom
	private int no;
	private String prtCode;
	private String capacity;
	private String matCode;
	private String prtName;
	private String matName;
	
	// material
	private String matSize;
	private int matUnitPrc;
	private String cpCode;
	private String prsCode;
	private String matoption;
	
	// warehouse
	private String whCode;
	private String whName;
	private String whLocation;
	private String whManager;
	
	// product 페이지 등록
	private String name;
	private String size;
	private int price;
	private String type;
	private String prtUnit;
	
	// product
	private String prtStandard;
	private int prtPrice;
	private String prtImage;
	
	// process
	private String prsName;
	private String prsDetail;
	private String eqmCode;
	
	// eqm
	private String eqmName;
	
	// error
	private String errCode;
	private String errName;
	private String errOption;
	private String errPct;
	private String errsCode;
	
	// process run
	private String prsNo;
	private String preNo;
	private String prsManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String prsDate;
	private String matOutNo;
	private int prtQty;
}

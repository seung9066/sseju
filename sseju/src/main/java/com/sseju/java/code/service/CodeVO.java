package com.sseju.java.code.service;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("CodeVO")
public class CodeVO {
	
	private String dell;
	private String msg;
	private String CpName;
	
	// code
	private String code;
	private String divName;
	private String codeName;
	private String divCode;
	
	// employee
	private String empId;
	private String empName;
	private String empDept;
	private String empRank;
	
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
	private int runNo;
	
	// eqm
	private String eqmName;
	
	// error
	private String errCode;
	private String errName;
	private String errOption;
	private String errPct;
	private String errsCode;
	private int prsErrQty;
	
	// process run
	private String prsNo;
	private String preNo;
	private String prsManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsDate;
	private String matOutNo;
	private int prtQty;
	private int lotQty;
	
	private int insQty;
	private String orderNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dDay;
	private int orderOutQty;
	
	private int orderQty;
	private int matOrdQty;
	private String nowCode;
	private String matOrdYn;
	private int matPrice;
	private String matOrdEmp;
	
	private int matInQty;
	private int matErrQty;
	private String matOrdNo;
	private int matPassQty;
	
	private int matNo;
	private String matErrRs;
	private String matErrDoc;
	private String prtOutNo;
	
	// Thread
	private String mpCode;
	private String lotNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lotDate;
	private String outForm;
	private String lotOption;
	private String matChkCode;
	private String prfNo;
	private int matOutQty;
	private String outType;
	private String outFrom;
	private String preManager;
	
	private String prsPfNo;
	private int prsOutPut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsStHour;
	private Date prsSpHour;
	private String prsErrNo;
}

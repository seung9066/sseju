package com.sseju.java.mat.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("MatVO")
public class MatVO {

//	MarerialVO
//	MAT_CODE	VARCHAR2(100 BYTE)
//	MAT_NAME	VARCHAR2(20 BYTE)
//	MAT_SIZE	VARCHAR2(10 BYTE)
//	MAT_UNIT_PRC	VARCHAR2(10 BYTE)
//	CP_CODE	VARCHAR2(50 BYTE)
//	PRS_CODE	VARCHAR2(50 BYTE)
	
	private String matCode;
	private String matName;
	private String matSize;
	private String matUnitPrc;
	private String cpCode;
	private String prsCode;

//	mat_outVO
//	MAT_OUT_NO	NUMBER
//	WH_CODE	VARCHAR2(50 BYTE)
//	MAT_CODE	VARCHAR2(100 BYTE)
//	MAT_OUT_DATE	DATE
//	MAT_OUT_QTY	NUMBER
//	MAT_LOT_NO	VARCHAR2(50 BYTE)
	
	private String matOutNo;
	private String WhCode;
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date matOutDate;
	private int matOutQty;
	private String matLotNo;
	
//	MatErrVO
//	MAT_NO	NUMBER
//	MAT_CHK_CODE	VARCHAR2(50 BYTE)
//	MAT_ERR_RS	VARCHAR2(50 BYTE)
//	MAT_ERR_DOC	VARCHAR2(50 BYTE)
//	ERR_CODE	VARCHAR2(50 BYTE)
	
	private int matNo;
	private String matErrRs;
	private String matErrDoc;
	private String errCode;
	
// MatchkVO
//	MAT_CHK_CODE	VARCHAR2(50 BYTE)
//	MAT_CHK_NAME	VARCHAR2(50 BYTE)
//	MAT_IN_QTY	NUMBER
//	MAT_ERR_QTY	NUMBER
//	MAT_ORD_NO	VARCHAR2(50 BYTE)
//	MAT_CHK_DATE	DATE
//	MAT_PASS_QTY	NUMBER
	
	private String matChkCode;
	private String matChkName;
	private int matInQty;
	private int matErrQty;
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date matChkDate;
	private int matPassQty;

//	MAR_BUY VO
//	MAT_ORD_NO	VARCHAR2(100 BYTE)
//	MAT_ORD_QTY	NUMBER
//	NOW_CODE	VARCHAR2(100 BYTE)
//	MAT_CODE	VARCHAR2(100 BYTE)
//	MAT_ORD_DATE	DATE
//	CP_CODE	VARCHAR2(50 BYTE)
//	MAT_ORD_YN	VARCHAR2(20 BYTE)
//	MAT_PRICE	VARCHAR2(20 BYTE)
//	MAT_ORD_EMP	VARCHAR2(20 BYTE)
	
	private String matOrdNo;
	private int matOrdQty;
	private String nowCode;
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date matOrdDate;
//	private String matOrdDate;
	private String matOrdYn;
	private String matPrice;
	private String matOrdEmp;
	

//	LOT VO
//	LOT_NO	VARCHAR2(50 BYTE)
//	LOT_DATE	DATE X
//	MP_CODE	VARCHAR2(50 BYTE)
//	OUT_FROM	VARCHAR2(50 BYTE) X
//	LOT_OPTION	VARCHAR2(50 BYTE) X
//	LOT_QTY	NUMBER
//	WH_CODE	VARCHAR2(50 BYTE)
//	MAT_CHK_CODE	VARCHAR2(50 BYTE)
	
	private String lotNo;
	@DateTimeFormat (pattern ="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date lotDate;
	private String mpCode;
	private int lotQty;

//	warehouse VO
//	WH_CODE	VARCHAR2(50 BYTE)
//	WH_NAME	VARCHAR2(50 BYTE)
//	WH_LOCATION	VARCHAR2(100 BYTE)
//	WH_MANAGER	VARCHAR2(50 BYTE)
	
	private String whCode;
	private String whName;
	private String whLocation;
	private String whManager;
	
//거래처 VO
	
	private String cpName;
	private String empName;
	private String empId;
		
	//VO
	private List<String> delno; // 삭제시 매치되는 자재번호
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate; // 시작일
	private String orderNo;
	private Integer orderQty;
	private String prtCode;
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dDay;
	private String prtName;
	private String capacity;
	
	//errVO
	private String code; //에러 테이블의 mat_code
	private String errName;
	private String errOption;
	private String errPct;

}

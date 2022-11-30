package com.sseju.java.lottrack.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//로트 추적을 위한 VO
@Data
@Alias("ltVO")
public class LotTrackVO {
	/*로트 추적을 위해 불러와야 하는 컬럼*/
	private String lotNo;	//로트번호(시리얼번호) lot 1, 완제품에 대한 로트번호일듯?
	private String mpCode;	//자재, 제품 코드  3
	private String outFrom;	//출고처 4
	private String lotOption;//구분 5(아직 사용하는곳 X)
	private int lotQty;		//생산수량(로트번호가 부여된 제품 단위의 총 개수) 6
	private int prsOutPut;	//완제품 생산수량
	private String prtQty; //로트 담당자 
		//ㄴlot - process_run의 담당자를 가져와야함 
	private String whManager; //로트 담당자 
		//ㄴ로트 표기에 창고담당자를할지,prs_run의 담당자로 가져와야할지 몰라서 
	private String empId;		//담당자명을 받아오기 위한 id값
	private String empName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lotDate;	//등록일자 lot테이블 2
	private String matChkCode;//검수코드, FK, matChk테이블의 외래키
	private String whCode;		//창고코드, FK,warehouse 테이블의 외래키
	private String prtName;		//제품명
	private String orderNo;		//주문번호
	

}

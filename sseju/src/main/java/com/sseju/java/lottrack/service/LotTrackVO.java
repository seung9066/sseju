package com.sseju.java.lottrack.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//로트 추적을 위한 VO
@Data
@Alias("ltVO")
public class LotTrackVO {
	/*로트 추적을 위해 불러와야 하는 컬럼*/
	private String lotNo;		//로트번호, lot테이블
	private String mpCode;		//제품코드, lot테이블
	private String lot_qty;		//생산된 상품 수량
	private String whManager;	//담당자(창고테이블에서 가져와야함)
	private String lotDate;		//로트 등록 일자
	private String whCode;		//창고코드
}

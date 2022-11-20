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
	private String lotNo;	//로트번호(시리얼번호) lot
	private String mpCode;	//자재, 제품 코드 
	private int lotQty;		//생산수량(로트번호가 부여된 제품 단위의 총 개수)
	private String lotManager; //로트 담당자
		//ㄴlot - process_run의 담당자를 가져와야함 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lotDate;	//등록일자 lot테이블
	private String whManager;	//담당자(
	private String whCode;		//창고코드
}

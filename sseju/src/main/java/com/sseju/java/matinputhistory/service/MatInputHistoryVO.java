package com.sseju.java.matinputhistory.service;


import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("mihVO")
public class MatInputHistoryVO {
	private String matCode;		//자재코드
	private String matName;		//자재명
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOutDate;	//자재 출고 일자(자재를 공정에 투입한 투입일자) mat_out테이블
	private String prsCode;		//공정코드(어떤 자재가 어느 공정으로 투입되었는지 체크)
	private String prsName;		//공정명 
	private int matOutQty;		//출고수량(자재가 공정에 투입된 수량)
	private int lotQty;			//투입 후 남은 재고수량
	private String prsManager;	//담당자명(자재를 공정으로 출고시킨담당자의 이름
		//ㄴ동명이인 가능성이 있기때문에 id로 emp테이블의 이름값을 가져와야한다
	private String empId;		//ㄴemp테이블의 이름을 가져오기 위해서
	private String preNo;		//작업 지시 번호
	
}

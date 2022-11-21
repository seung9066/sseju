package com.sseju.java.matrecchk.service;


import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("mrcVO")
public class MatRecChkVO {
//수입검사 페이지 VO
	private String matChkCode;		//검수코드 mat_chk 테이블의 pk
	private String matOrdNo;		//발주번호, mat_chk테이블
	private String cpCode;			//업체코드 (mat_buy, material 조인 후  업체명 끌어오기위해서)
	private String matName;			//자재명, material테이블에서 서브쿼리나 조인 사용해서 가져와야함
	private Integer matINQty;		//입고수, mat_chk테이블
	private Integer	matErrQty;		//불량 수, mat_chk 테이블
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matChkDate;		//검수일자
	
}

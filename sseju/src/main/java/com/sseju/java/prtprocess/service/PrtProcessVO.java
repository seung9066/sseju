package com.sseju.java.prtprocess.service;

import org.apache.ibatis.type.Alias;
import lombok.Data;
// 미사용 페이지
@Data
@Alias("prtpVO")
public class PrtProcessVO {
	private String prsCode;		//공정코드 process테이블
	private String prsName;		//공정명 process테이블
	private String lineNo;		//라인번호 eqm tbl
	private String eqmCheck;	//점검주기 eqm tbl
	private String lineYn;		//가동여부 eqm_line tbl
	private String eqmCode;		//설비코드 eqm_check tbl
}

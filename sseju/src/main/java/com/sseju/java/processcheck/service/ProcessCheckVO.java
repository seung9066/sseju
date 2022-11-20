package com.sseju.java.processcheck.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
//공정 검사 조회/관리 페이지용 VO
@Data
@Alias("pcVO")
public class ProcessCheckVO {
	private int prsNo;			//작업번호
	private String prsCode;		//공정코드 process tbl
	private String prsName;		//공정명	 process tbl
	private String errCode;		//불량코드 porcess_err tbl
	private String prsManager;	//공정 검사 담당자 process_run tbl, emp테이블에서 id끌어와서 써야함
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prsDate;		//작업일자 process_run tbl
}

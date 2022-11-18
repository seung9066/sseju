package com.sseju.java.matroder.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("moVO")
public class MatOrderVO {
	/*	meterial
	 *  생산 진행 현황 페이지에서 볼 자재 상황 그리드
	 * 부족한 자재 신청도 이 페이지에서도 바로 가능하게 연결할 예정*/
	private String matOrdName; 	//발주번호
	private int matOrdQty;		//발주량
	private String matCode;		//자재코드, material테이블에서 가져와야함
	private String matName;		//자재명, material테이블에서 가져와야함
	private Date matOrdDate;	//발주 신청 일자
	private String cpCode;		//자재 발주 신청할 업체 코드
	private String matOrdYn;	//발주 진행 여부
	private String matPrice;	//발주 금액
	private String matOrdEmp;	//발주담당자, 사원아이디테이블에서 join하여 이름출력 필요
	private String empId;		//사원아이디, 발주담당자 이름 출력 및 발주 시 담당자 등록을 위해
	
}

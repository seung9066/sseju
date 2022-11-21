package com.sseju.java.workorder.mapper;

import java.util.List;

import com.sseju.java.workorder.serivce.WorkOrderVO;

public interface WorkOrderMapper {
	//작업 지시 전체 조회
	public List<WorkOrderVO> getWorkOrderList();
	//작업 지시 단건 조회
	public WorkOrderVO getSearchWorkOrder();
	//작업 지시 등록
	public int insertWorkOrder(WorkOrderVO woVO);
	//수정
	public int updateWorkOrder(WorkOrderVO woVO);
	//삭제
	public int deleteWorkOrder(WorkOrderVO woVO);
	//작업지시 번호 조회
	public int getWoNo();
}

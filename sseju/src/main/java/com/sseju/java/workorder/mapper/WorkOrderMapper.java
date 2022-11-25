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
	//상품코드, 상품명 가져오기
	public List<WorkOrderVO> getPrtList();
	//사원아이디, 사원명 가져오기
	public List<WorkOrderVO> getWoEmpList();
	//주문번호, 상품명, 주문수량, 주문일자 가져오기
	public List<WorkOrderVO> getOrderList();
	//주문->작업지시 처리상태 order_yn값 변경
	public int updateOrderYn(WorkOrderVO woVO);
	//주문 신청 삭제 : 사용X
	public int deleteOrder(WorkOrderVO woVO);
}

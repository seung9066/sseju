package com.sseju.java.workorder.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.workorder.mapper.WorkOrderMapper;
import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
	
	@Autowired
	WorkOrderMapper woMapper;
	
	//전체조회
	@Override
	public List<WorkOrderVO> getWorkOrderList() {
		return woMapper.getWorkOrderList();
	}
	
	//단건조회
	@Override
	public WorkOrderVO getSearchWorkOrder() {
		return woMapper.getSearchWorkOrder();
	}
	
	//등록
	@Override
	public int insertWorkOrder(WorkOrderVO woVO) {
		 woMapper.insertWorkOrder(woVO);
		 return woMapper.updateOrderYn(woVO);
	}

	//수정
	@Override
	public int updateWorkOrder(WorkOrderVO woVO) {
		return woMapper.updateWorkOrder(woVO);
	}
	
	//삭제() 모든처리는 서비스에서, 리스트VO로
	@Override
	public int deleteWorkOrder(List<WorkOrderVO> deleteWorkOrder) {
		int res = 0;
		for(int i=0; i<deleteWorkOrder.size(); i++) {
			WorkOrderVO woVO = deleteWorkOrder.get(i);
			res += woMapper.deleteWorkOrder(woVO);
			woMapper.updateOrderYn(woVO);
		}
		return res;
	}
	
	//단건조회 하게되면 작업지시 번호 기준으로 하기위해서 작업 지시 번호 불러오는 메소드
	@Override
	public int getWoNo() {
		return woMapper.getWoNo();
	}
	//상품코드, 상품명 불러오기
	@Override
	public List<WorkOrderVO> getPrtList() {
		// TODO Auto-generated method stub
		return woMapper.getPrtList();
	}
	//사원명, 사원아이디 불러오기
	@Override
	public List<WorkOrderVO> getWoEmpList() {
		// TODO Auto-generated method stub
		return woMapper.getWoEmpList();
	}

	@Override
	public List<WorkOrderVO> getOrderList() {
		// TODO Auto-generated method stub
		return woMapper.getOrderList();
	}
	//주문->작업지시 등록 시 주문 그리드에서 등록 처리된 행은 사라지게 업데이트
	@Override
	public int updateOrderYn(WorkOrderVO woVO) {
		// TODO Auto-generated method stub
		return woMapper.updateOrderYn(woVO);
	}
	//주문 신청 내역 삭제
	@Override
	public int deleteOrder(WorkOrderVO woVO) {
		// TODO Auto-generated method stub
		return woMapper.deleteOrder(woVO);
	}

}

package com.sseju.java.prtprog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.prtprog.mapper.PrtProgMapper;
import com.sseju.java.prtprog.service.PrtProgService;
import com.sseju.java.prtprog.service.PrtProgVO;

@Service
public class PrtProgServiceImpl implements PrtProgService {
	
	@Autowired
	PrtProgMapper pprMapper;
	
	@Override
	public int insertPrtProg(PrtProgVO pprVO) {
		// TODO Auto-generated method stub
		return pprMapper.insertPrtProg(pprVO);
	}
	
	//생산 진행 현황 리스트 모두 불러오기
	@Override
	public List<PrtProgVO> getPrtProgList() {
		// TODO Auto-generated method stub
		return pprMapper.getPrtProgList();
	}
	//생산 진행 현황 삭제
	@Override
	public int deletePrtProg(PrtProgVO pprVO) {
		// TODO Auto-generated method stub
		return pprMapper.deletePrtProg(pprVO);
	}
	//생산 공정별 자재 상황 확인
	@Override
	public List<PrtProgVO> progPrtCondition(String preNo) {
		// TODO Auto-generated method stub
		return pprMapper.progPrtCondition(preNo);
	}

	@Override
	public int updateProgYtoE(PrtProgVO pprVO) {
		// TODO Auto-generated method stub
		return pprMapper.updateProgYtoE(pprVO);
	}

}

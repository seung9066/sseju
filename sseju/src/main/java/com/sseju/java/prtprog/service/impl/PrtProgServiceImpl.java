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
		return pprMapper.insertPrtProg(pprVO);
	}
	
	//생산 진행 현황 리스트 모두 불러오기
	@Override
	public List<PrtProgVO> getPrtProgList() {
		return pprMapper.getPrtProgList();
	}
	//생산 진행 현황 삭제
	@Override
	public int deletePrtProg(PrtProgVO pprVO) {
		return pprMapper.deletePrtProg(pprVO);
	}
	//생산 공정별 자재 상황 확인
	@Override
	public List<PrtProgVO> progPrtCondition(PrtProgVO pprVO) {
		return pprMapper.progPrtCondition(pprVO);
	}

	@Override
	public int updateProgYtoE(PrtProgVO pprVO) {
		return pprMapper.updateProgYtoE(pprVO);
	}

}

package com.sseju.java.prtper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.prtper.mapper.PrtPerMapper;
import com.sseju.java.prtper.service.PrtPerService;
import com.sseju.java.prtper.service.PrtPerVO;

@Service
public class PrtPerServiceImpl implements PrtPerService {
	
	@Autowired
	PrtPerMapper ppMapper;
	
	//생산 실적 등록
	@Override
	public int insertPrtPer(PrtPerVO ppVO) {
		// TODO Auto-generated method stub
		return ppMapper.insertPrtPer(ppVO);
	}
	
	//생산 실적 전체 조회
	@Override
	public List<PrtPerVO> getPrtPerList() {
		// TODO Auto-generated method stub
		return ppMapper.getPrtPerList();
	}

	//생산 실적 단건 조회
	@Override
	public PrtPerVO SelectPrtPer() {
		// TODO Auto-generated method stub
		return ppMapper.SelectPrtPer();
	}

	//생산 실적 삭제
	@Override
	public int deletePrtPer(PrtPerVO ppVO) {
		// TODO Auto-generated method stub
		return ppMapper.deletePrtPer(ppVO);
	}

	@Override
	public List<PrtPerVO> getErrList(PrtPerVO ppVO) {
		// TODO Auto-generated method stub
		return ppMapper.getErrList(ppVO);
	}

}

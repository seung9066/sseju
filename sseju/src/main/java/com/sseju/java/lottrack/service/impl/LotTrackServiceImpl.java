package com.sseju.java.lottrack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.lottrack.mapper.LotTrackMapper;
import com.sseju.java.lottrack.service.LotTrackService;
import com.sseju.java.lottrack.service.LotTrackVO;

@Service
public class LotTrackServiceImpl implements LotTrackService {
	
	@Autowired
	LotTrackMapper ltMapper;
	
	//로트 리스트 출력
	@Override
	public List<LotTrackVO> getLotTrackList() {
		return ltMapper.getLotTrackList();
	}

}

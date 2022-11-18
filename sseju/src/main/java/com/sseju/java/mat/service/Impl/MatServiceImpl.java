package com.sseju.java.mat.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.mat.mapper.MatMapper;
import com.sseju.java.mat.service.MatService;
import com.sseju.java.mat.service.MatVO;

@Service
public class MatServiceImpl implements MatService {
	
	@Autowired
	MatMapper matMapper;

	@Override
	public List<Map<String, Object>> matBuyList() {
		return matMapper.matBuyList();
	}

	@Override
	public MatVO selectMatbuyInfo(MatVO MatVO) {
		return matMapper.selectMatbuyInfo(MatVO);
	}

	@Override
	public int insertMatbuy(MatVO MatVO) {
		return matMapper.insertMatbuy(MatVO);
	}

	@Override
	public int updateMatbuy(MatVO MatVO) {
		return matMapper.updateMatbuy(MatVO);
	}

	@Override
	public int deleteMatbuy(MatVO MatVO) {
		return matMapper.deleteMatbuy(MatVO);
	}

	@Override
	public int selectDelete(List<String> list) {
		return matMapper.selectDelete(list);
	}

}

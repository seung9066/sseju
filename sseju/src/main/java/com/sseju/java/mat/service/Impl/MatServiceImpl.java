package com.sseju.java.mat.service.Impl;

import java.util.List;

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
	public List<MatVO> matordList() {
		return matMapper.matordList();
	}

	@Override
	public List<MatVO> matInList() {
		return matMapper.matInList();
	}


	@Override
	public List<MatVO> matOutList() {
		// TODO Auto-generated method stub
		return matMapper.matOutList();
	}


	@Override
	public List<MatVO> matStockList() {
		// TODO Auto-generated method stub
		return matMapper.matStockList();
	}


	@Override
	public List<MatVO> matCheckList() {
		// TODO Auto-generated method stub
		return matMapper.matCheckList();
	}

	@Override
	public List<MatVO> material() {
		// TODO Auto-generated method stub
		return matMapper.material();
	}


	@Override
	public int docUpdate(MatVO MatVO) {
		// TODO Auto-generated method stub
		return matMapper.docUpdate(MatVO);
	}

}

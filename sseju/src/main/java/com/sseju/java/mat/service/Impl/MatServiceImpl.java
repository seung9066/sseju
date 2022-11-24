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
	public int deleteMatbuy(List<String> matOrdNo) {
		int result = 0;
		for (String no : matOrdNo) {
			result += matMapper.deleteMatbuy(no);
		}
		return result;
	}

	/*
	 * @Override
   public int deleteMatrailInfo(List<String> mNo) {
      // 자재 정보 삭제 - 재고 수량도 삭제됨
      int result = 0;
      for (String no : mNo) {
         result += mMapper.deleteMatrailInfo(no);
      }
      return result;
   }
	 */
	@Override
	public int selectDelete(List<String> list) {
		return matMapper.selectDeleteMatbuy(list);
	}

	@Override
	public List<MatVO> matInList() {
		return matMapper.matInList();
	}

	@Override
	public MatVO selectMatIn(MatVO MatVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMat(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMat(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMat(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectDeleteMatIn(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatVO> matOutList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatVO selectMatOut(MatVO MatVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMatOut(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMatOut(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMatOut(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectDeleteMatOut(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatVO> matStockList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatVO selectMatStock(MatVO MatVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMatStock(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMatStock(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMatStock(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectDeleteMatStock(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatVO> matCheckList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatVO selectMatCheck(MatVO MatVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMatCheck(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMatCheck(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMatCheck(MatVO MatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectDeleteMatCheck(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatVO> material() {
		// TODO Auto-generated method stub
		return matMapper.material();
	}

	@Override
	public int insertMatord(MatVO MatVO) {
		// TODO Auto-generated method stub
		return matMapper.insertMatord(MatVO);
	}

	@Override
	public MatVO selectMatordno(MatVO MatVO) {
		// TODO Auto-generated method stub
		return matMapper.selectMatordno(MatVO);
	}

	@Override
	public int updateMatnotIn(MatVO MatVo) {
		// TODO Auto-generated method stub
		return matMapper.updateMatnotIn(MatVo);
	}

	@Override
	public List<MatVO> matNotinList() {
		// TODO Auto-generated method stub
		return matMapper.matNotinList();
	}

	@Override
	public int insertLot(MatVO MatVO) {
		// TODO Auto-generated method stub
		return matMapper.insertLot(MatVO);
	}

}

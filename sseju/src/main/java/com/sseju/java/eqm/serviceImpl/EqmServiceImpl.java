package com.sseju.java.eqm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.code.mapper.CodeMapper;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.eqm.mapper.EqmMapper;
import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;

@Service
public class EqmServiceImpl implements EqmService {

   @Autowired
   EqmMapper eqmMapper;
   @Autowired
   CodeMapper cdMapper;
   
   
   
//   설비 eqm

   @Override
   public List<EqmVO> selectEqmList() {
      return eqmMapper.selectEqmList();
   }
   
	 @Override
	 public int insertEqm(EqmVO eqmVO) {
	 	
	 int a = eqmMapper.insertEqm(eqmVO);
	 // 설비등록하는 동시에 공통코드에도 값 넣어주기
	 CodeVO vo = new CodeVO();
	 vo.setCode(eqmVO.getEqmCode());
	 vo.setDivName("설비");
	 vo.setDivCode("EQM");
	 vo.setCodeName(eqmVO.getEqmName());

	 cdMapper.insertCode(vo);

	 return a;
	 }
	 

   @Override
   public int updateEqmInfo(EqmVO eqmVO) {
      return eqmMapper.updateEqmInfo(eqmVO);
   }

   @Override
   public int deleteEqmInfo(EqmVO eqmVO) {
      return eqmMapper.deleteEqmInfo(eqmVO);
   }

// eqmLine
   @Override
   public List<EqmVO> getEqmLineList() {
      return eqmMapper.getEqmLineList();
   }

   @Override
   public EqmVO getEqmLineInfo(EqmVO eqmVO) {
      return eqmMapper.getEqmLineInfo(eqmVO);
   }

   
   @Override
   public int insertEqmLine(EqmVO eqmVO) {
      return eqmMapper.insertEqmLine(eqmVO);
   }

   @Override
   public int updateEqmLine(EqmVO eqmVO) {
      return eqmMapper.updateEqmLine(eqmVO);
   }

   @Override
   public int deleteEqmLine(EqmVO eqmVO) {
      return eqmMapper.deleteEqmLine(eqmVO);
   }

// 정기점검 eqmChk
   @Override
   public List<EqmVO> getEqmChkList() {
      // TODO Auto-generated method stub
      return eqmMapper.getEqmChkList();
   }


   @Override
   public int insertEqmChk(EqmVO eqmVO) {
      // TODO Auto-generated method stub
      return eqmMapper.insertEqmChk(eqmVO);
   }

   @Override
   public int updateEqmChk(EqmVO eqmVO) {
      // TODO Auto-generated method stub
      return eqmMapper.updateEqmChk(eqmVO);
   }

   @Override
   public int deleteEqmChk(EqmVO eqmVO) {
      // TODO Auto-generated method stub
      return eqmMapper.deleteEqmChk(eqmVO);
   }

@Override
public List<EqmVO> getUoperList() {
	// TODO Auto-generated method stub
	return eqmMapper.getUoperList();
}

@Override
public int insertUoper(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.insertUoper(eqmVO);
}

@Override
public int deleteUoper(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.deleteUoper(eqmVO);
}

@Override
public List<EqmVO> getEmpList() {
	// TODO Auto-generated method stub
	return eqmMapper.getEmpList();
}

@Override
public int updateUoper(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.updateUoper(eqmVO);
}

@Override
public int deleteEqm(List<String> deleteEqm) {
	int a = 0;
	for (int i = 0; i < deleteEqm.size(); i++) {
		String line1 = deleteEqm.get(i);

		EqmVO vo = new EqmVO();
		vo.setEqmCode(line1);
		a += eqmMapper.deleteEqmInfo(vo);
		
		//공통코드에서도 삭제해주기
		CodeVO cvo = new CodeVO();
		cvo.setCode(line1);
		cdMapper.deleteCode(cvo);
	}
	return a;
}



@Override
public int deleteLine(List<String> line) {
	int a = 0;
	for (int i = 0; i < line.size(); i++) {
		String line1 = line.get(i);

		EqmVO vo = new EqmVO();
		vo.setLineNo(line1);

		a += eqmMapper.deleteEqmLine(vo);
	}
	return a;
}

@Override
public int deleteChk(List<String> deleteChk) {
	int a = 0;
	for (int i = 0; i < deleteChk.size(); i++) {
		String line1 = deleteChk.get(i);

		EqmVO vo = new EqmVO();
		vo.setChkNo(line1);
		System.out.println(vo.getChkNo());
		a += eqmMapper.deleteEqmChk(vo);
	}

	return a;
}

@Override
public int deleteUoper(List<String> deleteUoper) {
	int a = 0;
	for (int i = 0; i < deleteUoper.size(); i++) {
		String line1 = deleteUoper.get(i);

		EqmVO vo = new EqmVO();
		vo.setUoperCode(line1);
		a += eqmMapper.deleteUoper(vo);
	}

	return a;
}

@Override
public int updateEqmYn(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.updateEqmYn(eqmVO);
}


//점검주기 모달
@Override
public List<EqmVO> getChkList() {
	// TODO Auto-generated method stub
	return eqmMapper.getChkList();
}





   

   


   

}
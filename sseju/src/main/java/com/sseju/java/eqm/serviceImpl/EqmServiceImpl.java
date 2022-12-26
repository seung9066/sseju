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
	 public int insertEqm(EqmVO eqmVO)   {
	 	
	 // 설비등록하는 동시에 공통코드에도 값 넣어주기
	 CodeVO vo = new CodeVO();
	 vo.setCode(eqmVO.getEqmCode());
	 vo.setDivName("설비");
	 vo.setDivCode("EQM");
	 vo.setCodeName(eqmVO.getEqmName());

	 cdMapper.insertCode(vo);
	 
	 return eqmMapper.insertEqm(eqmVO);

	 } 
	 

   @Override
   public int updateEqmInfo(EqmVO eqmVO) {
      return eqmMapper.updateEqmInfo(eqmVO);
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
public List<EqmVO> getUoperList() {
	// TODO Auto-generated method stub
	return eqmMapper.getUoperList();
}

@Override
public int insertUoper(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	eqmMapper.updateEqmYn(eqmVO);
	return eqmMapper.insertUoper(eqmVO);
}

@Override
public int deleteUoper(EqmVO eqmVO) {
	return eqmMapper.deleteUoper(eqmVO);
}

@Override
public List<EqmVO> getEmpList() {
	// TODO Auto-generated method stub
	return eqmMapper.getEmpList();
}

@Override
public int updateUoper(EqmVO eqmVO) {
	
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


/*라인정보 삭제*/

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





@Override
public EqmVO getEqmInfo(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.getEqmInfo(eqmVO);
}



@Override
public List<CodeVO> getUoperCode() {
	// TODO Auto-generated method stub
	return eqmMapper.getUoperCode();
}



@Override
public int updateUoprCd(CodeVO vo) {
	// TODO Auto-generated method stub
	int a = 0;
	a += eqmMapper.updateUoprCd(vo);
	return a;
}



@Override
public int insUoprCode(CodeVO vo) {
	int a = 0;
	a += eqmMapper.insUoprCode(vo);
	return a;
}



@Override
public List<EqmVO> getFixingList() {
	
	return eqmMapper.getFixingList();
}






@Override
public int updateFix(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	int a = 0;
	a += eqmMapper.updateFix(eqmVO);
	//a += eqmMapper.updIng(eqmVO);
	return a;
}



/*
 * @Override public int delFix(List<String> delFix) { int a = 0; for (int i = 0;
 * i < delFix.size(); i++) { String line1 = delFix.get(i);
 * 
 * EqmVO vo = new EqmVO(); vo.setFixNo(line1); a += eqmMapper.delFix(vo); }
 * return a; }
 */



@Override
public List<EqmVO> getReqList() {
	// TODO Auto-generated method stub
	return eqmMapper.getReqList();
}



@Override
public int fixingDel(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.fixingDel(eqmVO);
}



@Override
public int insFix(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.insFix(eqmVO);
}



@Override
public List<EqmVO> getFixedList() {
	// TODO Auto-generated method stub
	return eqmMapper.getFixedList();
}



@Override
public int fixedDel(EqmVO eqmVO) {
	// TODO Auto-generated method stub
	return eqmMapper.fixedDel(eqmVO);
}








@Override
public int deleteUoperCd(List<String> deleteUoperCd) {
	int a = 0;
	for (int i = 0; i < deleteUoperCd.size(); i++) {
		String line1 = deleteUoperCd.get(i);

		CodeVO vo = new CodeVO();
		vo.setCode(line1);
		a += eqmMapper.deleteUoperCd(vo);
	}
	return a;
}



























 
 




   

   


   

}
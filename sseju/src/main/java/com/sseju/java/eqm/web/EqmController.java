package com.sseju.java.eqm.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;
import com.sseju.java.eqm.service.FileRenamePolicy;
import com.sseju.java.eqm.service.FileUtil;


@Controller
public class EqmController {
	
	@Value("${filepath}")  //properties 값 불러오기
	private String filepath;

	@Autowired
	EqmService eqmService;
	@Autowired
	CompanyService cService;
	@Autowired
	CodeService cdService;
	@Autowired
	EmployeeService eService;
	
	// 비가동 공통코드 등록
	@PostMapping("insUoprCode")
	@ResponseBody
	public int insUoprCode(CodeVO vo) {
	 System.out.println("결과" + vo);
	 return eqmService.insUoprCode(vo);
	}

	// 거래처 정보
	@GetMapping("/cpList")
	@ResponseBody
	public List<CompanyVO> getCompanyList() {
		return cService.getCompanyList();
	}
	
	// 직원 정보
	  @GetMapping("eList")
	   @ResponseBody
	   public List<EqmVO> getEmpList(){
	      return eqmService.getEmpList();
	   }
	  
		/*
		 * // 직원 정보
		 * 
		 * @GetMapping("getReqList")
		 * 
		 * @ResponseBody public List<EqmVO> getReqList(){ EqmVO vo = new EqmVO();
		 * vo.setEqmCode(vo.getEqmCode()); vo.setFix_req_date(vo.getChkNdate());
		 * vo.setFix_state("수리요청"); return eqmService. }
		 */


	@GetMapping("/eqmList")
	public String eqmList(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		return "admin/eqm/eqmList";
	}

	@GetMapping("/eqmBasic")
	public String lineList() {
		return "admin/eqm/eqmBasic";
	}

	@GetMapping("/eqmCheck")
	public String eqmCheck(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		model.addAttribute("eqmm", eqmService.selectEqmList());
		return "admin/eqm/eqmCheck";
	}
	
	

	@GetMapping("/eqmUoper")
	public String eqmUoper(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		return "admin/eqm/eqmUoper";
	}
	
	@GetMapping("/eqmFixed")
	public String eqmFixed(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		model.addAttribute("eqm", eqmService.selectEqmList());
		return "admin/eqm/eqmFixed";
	}
	
	
	
	@GetMapping("/eqmState")
	public String eqmState() {
		return "admin/eqm/eqmState";
	}

	//설비 리스트
	@GetMapping("/getEqmList")
	@ResponseBody
	public List<EqmVO> getEqmList(Model model) {

		 return eqmService.selectEqmList();
		 
	}
	
	// 비가동 코드만 공통코드에서 빼오기
		@GetMapping("/getUoperCode")
		@ResponseBody
		public List<CodeVO> getUoperCode(Model model) {
			 return eqmService.getUoperCode();
			 
		}

	
	//설비 단건조회
		@ResponseBody
		@GetMapping("/getEqmInfo")
		public EqmVO getEqmInfo(EqmVO eqmVO) {
			return eqmService.getEqmInfo(eqmVO); // ajax의 데이터를 보여줘야기때문에 데이터로 return
		}
	
	


	@GetMapping("/eqmChkList")
	@ResponseBody
	public List<EqmVO> eqmChkList() {
		return eqmService.getEqmChkList();
	}
	
	// 정기점검 리스트 가져오기
	@GetMapping("/chkList")
	@ResponseBody
	public List<EqmVO> chkList(){
	
		return eqmService.getChkList();
	}
	
	// 정기점검에서 '수리요청' 들어간 애들만 가져오기
		@GetMapping("/getReqList")
		@ResponseBody
		public List<EqmVO> getReqList(){
		
			return eqmService.getReqList();
		}
	
	

	@GetMapping("/uoperList")
	@ResponseBody
	public List<EqmVO> uoperList() {
		return eqmService.getUoperList();
	}
	
	@GetMapping("/getFixingList")
	@ResponseBody
	public List<EqmVO> getFixingList() {
		return eqmService.getFixingList();
	}
	
	@GetMapping("/getFixedList")
	@ResponseBody
	public List<EqmVO> getFixedList() {
		return eqmService.getFixedList();
	}

	@PostMapping("/deleteEqm")
	@ResponseBody
	public int deleteEqm(@RequestParam(value = "deleteEqm[]", required = false) List<String> deleteEqm) {
		return eqmService.deleteEqm(deleteEqm);
	}
	

	
	
	@PostMapping("/deleteChk")
	@ResponseBody
	public int deleteChk(@RequestParam(value = "chk[]", required = false) List<String> deleteChk) {
	
		return eqmService.deleteChk(deleteChk);
	}

	@PostMapping("insertEqm")
	@ResponseBody
	public int insertEqm(EqmVO eqmVO, MultipartFile imageFile) throws IllegalStateException, IOException  {
		if(imageFile != null && imageFile.getSize() >0) {
	         //첨부파일 처리
	         String fName = imageFile.getOriginalFilename(); // 이미지 실제 이름
	         
	         File file = new File(filepath, fName);         
	         file = FileRenamePolicy.rename(file); // 파일 중복 검사
	         
	         imageFile.transferTo(file); // 파일을 폴더로 옮겨줌
	         //eqmVO.setEqmImg(file.getName());
	         eqmVO.setEqmImg(fName);
	      }
	      
		return eqmService.insertEqm(eqmVO);
		
		
	}
	
	   // 파일 다운
	   @GetMapping("/eqm/filedown")
	   public void fileDown (String fname, HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      FileUtil.fileDownload(filepath + fname, request, response); 
	      // path는 application.properties에 선언되어있음
	   }
	

	   

	@PostMapping("/updateEqm")
	@ResponseBody
	public int updateEqm(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmInfo(eqmVO);
	}

	@GetMapping("/lineList")
	@ResponseBody
	public List<EqmVO> getEqmLineList() {
		return eqmService.getEqmLineList();
	}

	@PostMapping("insertLine")
	@ResponseBody
	public int insertLine(EqmVO eqmVO) {

		int result = eqmService.insertEqmLine(eqmVO);
		return result;

	}

	@PostMapping("insertEqmChk")
	@ResponseBody
	public int insertChk(EqmVO eqmVO)  {
		
		return eqmService.insertEqmChk(eqmVO);
		
	}

	//비가동 등록
	
	@PostMapping("insertUoper")
	@ResponseBody
	public int insertUoper(@RequestBody EqmVO eqmVO,Model mode) {
		int a =0;
		 a += eqmService.insertUoper(eqmVO);
		 a+=eqmService.updateEqmYn(eqmVO);
		 return a;
	}
	//비가동 수정
	
	@RequestMapping("/updateUoper")
	@ResponseBody
	public int updateUoper(@RequestBody EqmVO eqmVO) {
		int a = 0;
			a +=eqmService.updateEqmYn(eqmVO);
		 	a +=eqmService.updateUoper(eqmVO);
			
		return a;
	}
	
	//비가동 공통코드 수정
	
		@RequestMapping("/updateUoprCd")
		@ResponseBody
		public int updateUoprCd(@RequestBody CodeVO vo) {
			return eqmService.updateUoprCd(vo);
		}
	
	// 비가동 공통코드 삭제
		@PostMapping("/deleteUoperCd")
		@ResponseBody
		public int deleteUoperCd(@RequestParam(value = "deleteUoperCd[]"
				+ "", required = false) List<String> cd) {
			return eqmService.deleteUoperCd(cd);
		}
		
		


	@PostMapping("/deleteLine")
	@ResponseBody
	public int deleteLine(@RequestParam(value = "delLine[]"
			+ "", required = false) List<String> line) {
		return eqmService.deleteLine(line);
	}

	@RequestMapping("/updateLine")
	@ResponseBody
	public int updateLine(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmLine(eqmVO);
	}

	@RequestMapping("/updateChk")
	@ResponseBody
	public int updateChk(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmChk(eqmVO);
	}
	
	// 수리이력 등록
		@PostMapping("/insFix")
		@ResponseBody
		public int insFix(@RequestBody List<EqmVO> list) {
			int a = 0;
			for(int i = 0; i<list.size(); i++) {
				System.out.println("for문");
				a += eqmService.insFix(list.get(i));
			}
			return a;
		}
		
	// 수리이력 수정
		@PostMapping("updateFix")
		@ResponseBody
		public int updateFix(@RequestBody List<EqmVO> updList) {
			int a = 0;
			for(int i = 0; i<updList.size(); i++) {
				a += eqmService.updateFix(updList.get(i));
			}
			return a;
		}
	
		// 수리중 삭제
				@PostMapping("fixingDel")
				@ResponseBody
				public int fixingDel(@RequestBody List<EqmVO> fixingList) {
					int a = 0;
					for(int i = 0; i<fixingList.size(); i++) {
						a += eqmService.fixingDel(fixingList.get(i));
					}
					return a;
				}
				
				// 수리완료 삭제
				@PostMapping("fixedDel")
				@ResponseBody
				public int fixedDel(@RequestBody List<EqmVO> fixedList) {
					int a = 0;
					for(int i = 0; i<fixedList.size(); i++) {
						a += eqmService.fixedDel(fixedList.get(i));
					}
					return a;
				}
				
				// 비가동 내역 삭제
				@PostMapping("/deleteUoper")
				@ResponseBody
				public int deleteUoper(@RequestBody List<EqmVO> uoperList) {
					int a = 0;
					for(int i=0; i<uoperList.size(); i++) {
						a += eqmService.deleteUoper(uoperList.get(i));
					}
					return a;
				}
	
	
	
	
	
	

}
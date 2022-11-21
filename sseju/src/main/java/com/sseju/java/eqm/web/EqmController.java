package com.sseju.java.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;

@Controller
public class EqmController {
   
   @Autowired
      EqmService eqmService;
  
  
   
     @GetMapping("/eqmList")
       public String eqmList() {
         return "/admin/eqm/eqmList";
      }
     @GetMapping("/eqmBasic")
     public String lineList() {
       return "/admin/eqm/eqmBasic";
    }
     
     @GetMapping("/eqmCheck")
      public String eqmCheck() {
         return "/admin/eqm/eqmCheck";
      }
     @GetMapping("/eqmUoper")
      public String eqmUoper() {
         return "/admin/eqm/eqmUoper";
      } 
     
     @GetMapping("/getEqmList")
     @ResponseBody
     public List<EqmVO> getEqmList(){
    	
        return eqmService.selectEqmList();
     }
     
     @GetMapping("/eqmChkList")
     @ResponseBody
     public List<EqmVO> eqmChkList(){
        return eqmService.getEqmChkList();
     }
     
     @GetMapping("/uoperList")
     @ResponseBody
     public List<EqmVO> uoperList(){
        return eqmService.getUoperList();
     }
     
     @PostMapping("/deleteEqm")
     @ResponseBody
     public int deleteEqm(@RequestParam(value= "deleteEqm[]", required=false) List<String> deleteEqm) {
        int a = 0;
        for(int i=0; i<deleteEqm.size(); i++) {
           String line1 = deleteEqm.get(i);
           
           EqmVO vo = new EqmVO();
           vo.setEqmCode(line1);
           
           a  += eqmService.deleteEqmInfo(vo);
        }
        return a;
     }
     
     @PostMapping("/deleteChk")
     @ResponseBody
     public int deleteChk(@RequestParam(value= "chk[]", required=false) List<String> deleteChk) {
        int a = 0;
        for(int i=0; i<deleteChk.size(); i++) {
           String line1 = deleteChk.get(i);
           
           EqmVO vo = new EqmVO();
           vo.setChkNo(line1);
           
           a  += eqmService.deleteEqmChk(vo);
        }
        return a;
     }
     
     
     @PostMapping("insertEqm")
     @ResponseBody
     public String insertEqm(EqmVO eqmVO) {
        eqmService.insertEqmInfo(eqmVO);
        return "redirect:eqmList";
     }
     
     @PostMapping("/updateEqm")
     @ResponseBody
     public int updateEqm(EqmVO eqmVO) {
        return eqmService.updateEqmInfo(eqmVO);
     }
     
     @PostMapping("/updateChk")
     @ResponseBody
     public int updateChk(EqmVO eqmVO) {
        return eqmService.updateEqmChk(eqmVO);
     }
     
     @GetMapping("/lineList")
     @ResponseBody
     public List<EqmVO> getEqmLineList(){
        return eqmService.getEqmLineList();
     }
     
     @PostMapping("insertLine")
     @ResponseBody
     public String insertLine(EqmVO eqmVO) {
        eqmService.insertEqmLine(eqmVO);
        return "redirect:eqmBasic";
     }
     
     @PostMapping("insertUoper")
     @ResponseBody
     public String insertUoper(EqmVO eqmVO) {
        eqmService.insertUoper(eqmVO);
        return "redirect:eqmUoper";
     }

     @PostMapping("/deleteLine")
     @ResponseBody
     public int deleteLine(@RequestParam(value= "line[]", required=false) List<String> line) {
        int a = 0;
        for(int i=0; i<line.size(); i++) {
           String line1 = line.get(i);
           
           EqmVO vo = new EqmVO();
           vo.setLineNo(line1);
           
           a  += eqmService.deleteEqmLine(vo);
        }
        return a;
     }
     
     @PostMapping("/updateLine")
     @ResponseBody
     public int updateLine(EqmVO eqmVO) {
        return eqmService.updateEqmLine(eqmVO);
     }
     
  
     
     

   


}
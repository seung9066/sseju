package com.sseju.java.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;

@Controller
public class EqmController {
   
   @Autowired
      EqmService eqmService;

   
     @GetMapping("/eqmList")
      public String eqmList(Model model) {
        
         return "/admin/eqm/eqmList";
      }
     
     @GetMapping("/eqmCheck")
      public String eqmCheck() {
         return "/admin/eqm/eqmCheck";
      }
     @GetMapping("/eqmUoper")
      public String eqmUoper() {
         return "/admin/eqm/eqmUoper";
      } 
     
     @GetMapping("/lineList")
     @ResponseBody
     public List<EqmVO> getEqmLineList(Model model){
        return eqmService.getEqmLineList();
     }
     
  
     
     

   


}
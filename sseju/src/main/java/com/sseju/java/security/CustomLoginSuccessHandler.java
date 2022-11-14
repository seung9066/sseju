package com.sseju.java.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

/*
 * 로그인 완료 후에 추가작업
 */
public class CustomLoginSuccessHandler 
       implements AuthenticationSuccessHandler{
	
	@Autowired
	EmployeeService service;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		EmployeeVO vo = new EmployeeVO();
		vo.setEmpId(authentication.getName());
		request.getSession().setAttribute("user", service.getEmpInfo(vo));
		//사용자
		response.sendRedirect(request.getContextPath() + "/dashboard");
	}
}

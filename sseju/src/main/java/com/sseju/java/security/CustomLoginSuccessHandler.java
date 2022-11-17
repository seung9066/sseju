package com.sseju.java.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

/*
 * 로그인 완료 후에 추가작업
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	EmployeeService serviceE;
	
	@Autowired
	CompanyService serviceC;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_COMPANY"))) {
			CompanyVO vo = new CompanyVO();
			vo.setId(authentication.getName());
			request.getSession().setAttribute("user", serviceC.getCompanyInfoId(vo));
			response.sendRedirect(request.getContextPath() + "/orlist");
		} else {
			EmployeeVO vo = new EmployeeVO();
			vo.setEmpId(authentication.getName());
			request.getSession().setAttribute("user", serviceE.getEmpInfo(vo));
			// 사용자

			response.sendRedirect(request.getContextPath() + "/dashboard");
		}

	}
}

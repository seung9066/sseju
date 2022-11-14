package com.sseju.java.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/*
 * 로그인 완료 후에 추가작업
 */
public class CustomLoginSuccessHandler 
       implements AuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		request.getSession().setAttribute("username", "홍길동");
		//사용자
		response.sendRedirect(request.getContextPath() + "/dashboard");
	}
}

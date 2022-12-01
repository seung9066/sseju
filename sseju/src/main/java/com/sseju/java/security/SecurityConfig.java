package com.sseju.java.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomLoginSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
							requests
							.antMatchers("/", "/login", "/accountform", "/idCheck", "/newCpAccount").permitAll()
							.antMatchers("/orlist", "/user/**", "/error", "/msgCount").hasAnyAuthority("ROLE_COMPANY", "ROLE_ADMIN")
							.antMatchers("/**").hasAuthority("ROLE_ADMIN")
							.anyRequest().authenticated())
				.formLogin().loginPage("/login")
							.usernameParameter("userId")
							.loginProcessingUrl("/login")
							.successHandler(successHandler())
//							.defaultSuccessUrl("/dashboard")
							.and()
				.logout().logoutUrl("/logout")
					      .logoutSuccessUrl("/login")
						 .invalidateHttpSession(true)
						 .deleteCookies("JSESSIONID")
						 .and()
				.exceptionHandling()
					     .accessDeniedHandler(accessDeniedHandler())
					     .and()
				// .csrf().disable()
			    // .userDetailsService(userService());
					     ;
		
		return http.build();
	}

	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/assets/**", "/bootstrap/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String loginSql = "select ID, PASSWORD, 1 from LOGIN where ID = ?";
		String authSql = "select ID, AUTH from LOGIN where ID = ?";		
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(loginSql)
		    .authoritiesByUsernameQuery(authSql)
		//    .passwordEncoder(passwordEncoder())
		    ;
	}

	
}

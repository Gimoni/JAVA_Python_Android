package com.example;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
	public SecurityConfig() {
		System.out.println("SecurityConfig()...");
		
		// 메소드 체인 설명
		"Hello".toUpperCase()
			   .toLowerCase()
			   .stripIndent()
			   .toString();
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 보안강화 
		http.csrf().disable()
			.cors().disable();
		
		//http request에 대해 권한을 허용 : url 기본 권한 설정
		http.authorizeHttpRequests()
			.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.requestMatchers("/webjars/**").permitAll()
			.requestMatchers("/img/**").permitAll()
			.requestMatchers("/admin/**").hasAnyRole("ADMIN")
			.requestMatchers("/security").permitAll()
			.anyRequest().authenticated();
		
		
		http.formLogin()
			.loginPage("/login")
//			.loginProcessingUrl("/login-prosess")
//			.usernameParameter("user")
//			.passwordParameter("pw")
			.successHandler((request, response, auth) -> {
				response.sendRedirect("/");
			})
			.failureHandler((request, response, e) -> {
				request.setAttribute("exception", e); // 에러에 대한 정보를 보냄 
				request.getRequestDispatcher("/loginFail").forward(request, response);
			})
			.permitAll();
		
		http.logout(Customizer.withDefaults());
		
		System.out.println("filterChain()...");
		return http.build();
	}


}

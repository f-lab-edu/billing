package com.pay.billing.common.security;

import com.pay.billing.common.exception.token.validateTokenException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
OncePerRequestFilter를 상속하여 구현한 경우 doFilter 대신 doFilterInternal 메서드를 구현
이렇게 필터를 정의하였으면 bean 선언만 하면 spring boot를 사용하는 경우 자동으로 filter가 추가되게 된다.

JwtTokenFilter 역할: JwtTokenFilter필터는 각각의 API에 인가된다 ex) /users/signin ,/users/signup.
1. Authorization 헤더에서 액세스 토큰을 확인한다.
2. 헤더에 액세스 토큰이있는 경우 인증을 위임한다.
3. JwtTokenProvider은 인증 프로세스의 결과에 따라 미충족시 인증 예외를 발생 시킵니다.
*/
public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 헤더의 req.getHeader("Authorization") 값을 가져와 유효 하다면 값을 가져온다.
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (validateTokenException ex) {
            /*
            ThreadLocal 에 있는 SecurityContext 를 제거하는 역할
            SecurityContextHolder.clearContext() 가 실행되기 전에 어떤 시점에서
            SecurityContext 객체를 HttpSession 에 저장하는 처리를 먼저 하게 됩니다.
             */
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(ex.getHttpStatus().value(), ex.getMessage());
            return;
        }

        // 인증 성공시 호출
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}

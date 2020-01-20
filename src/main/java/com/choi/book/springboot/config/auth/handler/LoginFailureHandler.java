package com.choi.book.springboot.config.auth.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("userName", userName);
        request.setAttribute("errorMsg", "가입하지 않은 아이디이거나,<br>잘못된 비밀번호입니다.");

        request.getRequestDispatcher("/login").forward(request,response);

    }
}

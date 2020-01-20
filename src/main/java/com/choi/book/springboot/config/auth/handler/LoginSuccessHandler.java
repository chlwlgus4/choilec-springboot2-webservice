package com.choi.book.springboot.config.auth.handler;

import com.choi.book.springboot.config.auth.dto.SessionUser;
import com.choi.book.springboot.domain.user.User;
import com.choi.book.springboot.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    HttpSession httpSession;

    public LoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    /**
     * 인증에 성공할 경우 아래 매서드로 이동.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String email = authentication.getName();
        User entity = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        httpSession.setAttribute("user", new SessionUser(entity));

        response.sendRedirect("/");
    }
}


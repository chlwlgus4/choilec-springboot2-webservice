package com.choi.book.springboot.config.auth;

import com.choi.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화시켜 줌
public class
SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console화면을 사용하기 위해 해당 옵션들을 disable 합니다.
                .and()
                .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/images/slide/**", "/js/**", "/h2-console/**", "/profile", "/login/**", "/register/**", "/forgotpwd/**").permitAll()
                //antMatchers 권한 관리 대상을 지정하는 옵션
                //"/"등 지정된 URL들은 primitAll() 옵션을 통해 전체 열람 권한을 줌줌
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                //anyRequest 설정된 값들 이외 나머지 URL들을 나타냄
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
                .and()
                .formLogin()
                .successForwardUrl("/")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}

package com.choi.book.springboot.service.user;

import com.choi.book.springboot.config.auth.dto.SessionUser;
import com.choi.book.springboot.domain.user.Role;
import com.choi.book.springboot.domain.user.User;
import com.choi.book.springboot.domain.user.UserRepository;
import com.choi.book.springboot.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    public String save(UserSaveRequestDto requestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(requestDto.toEntity());
        return "";
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User entity = userRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        List<GrantedAuthority> authorities = new ArrayList<>();

        String email = "";
        String password = "";

        if (entity != null) {
            email = entity.getEmail();
            password = entity.getPassword();
            if (("admin@example.com").equals(username)) {
                authorities.add(new SimpleGrantedAuthority(Role.USER.getKey()));
            } else {
                authorities.add(new SimpleGrantedAuthority(Role.USER.getKey()));
            }
            return new UserDetailsImpl(email, password, authorities);
        }
        return new UserDetailsImpl(email, password, authorities);
    }
}

package com.choi.book.springboot.web.dto;

import com.choi.book.springboot.domain.user.Role;
import com.choi.book.springboot.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private String email;
    private String password;
    private String name;
    private Role role;
    private String picture;

    public UserResponseDto(User entity) {
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.role = entity.getRole();
        this.picture = entity.getPicture();
    }
}

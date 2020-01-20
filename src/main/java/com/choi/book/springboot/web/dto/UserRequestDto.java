package com.choi.book.springboot.web.dto;

import com.choi.book.springboot.domain.posts.Posts;
import com.choi.book.springboot.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String picture;

    public UserRequestDto(User entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.picture = entity.getPicture();
    }
}

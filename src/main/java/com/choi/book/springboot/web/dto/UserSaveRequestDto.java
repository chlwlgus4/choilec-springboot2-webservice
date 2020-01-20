package com.choi.book.springboot.web.dto;

import com.choi.book.springboot.domain.user.Role;
import com.choi.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
    private Long id;
    private String attributes;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String picture;

    @Builder
    public UserSaveRequestDto(Long id, String attributes, String name, String email, String password, Role role, String picture) {
        this.id = id;
        this.attributes = attributes;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.picture = picture;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .picture(picture)
                .role(role.USER)
                .build();
    }
}

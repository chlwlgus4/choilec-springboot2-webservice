package com.choi.book.springboot.web;

import com.choi.book.springboot.domain.user.User;
import com.choi.book.springboot.service.user.UserService;
import com.choi.book.springboot.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user/api")
    public String save(@RequestBody UserSaveRequestDto requestDto) {
        userService.save(requestDto);
        return "";
    }

}

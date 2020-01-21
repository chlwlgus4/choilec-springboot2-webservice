package com.choi.book.springboot.web;

import com.choi.book.springboot.service.user.UserService;
import com.choi.book.springboot.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user/api/duple")
    public boolean emailChk(@RequestBody String email) {
        return userService.dupleChk(email);
    }

    @PostMapping("/user/api/save")
    public String save(@RequestBody UserSaveRequestDto requestDto) {
        userService.save(requestDto);
        return "";
    }

}

package com.choi.book.springboot.web;

import com.choi.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json 반환 메소드마다 ResponseBody 대역
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")           //requestParam ... Get 요청시 해당 이름을 파라미터로 넘겨서 여기서 받는 값
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

    @GetMapping("/aa")
    public String aa(){
        return "aa";
    }
}

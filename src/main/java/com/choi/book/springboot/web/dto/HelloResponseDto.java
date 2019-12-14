package com.choi.book.springboot.web.dto;

import lombok.*;

//@Getter
//@RequiredArgsConstructor //final 필드에 만 생성자 부여
public class HelloResponseDto {

    private  String name;
    private  int amount;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}

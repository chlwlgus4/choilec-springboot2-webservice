package com.choi.book.springboot.web.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor //final 필드에 만 생성자 부여
public class HelloResponseDto {

    private final String name;
    private final int amount;


}

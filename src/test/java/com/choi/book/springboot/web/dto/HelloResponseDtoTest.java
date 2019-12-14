package com.choi.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        //assertj 검증 라이브러리 검증 메서드.
        // 검증 대상을 인자로 받고, 메서드 체이닝을 통해 메서드 이어서 사용.
        //assertj 에 비해 추가 라이브러리 필요, 자동완성 부족
    }

}
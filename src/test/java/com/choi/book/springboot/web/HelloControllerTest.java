package com.choi.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)    //테스트 진행시 JUnit 에 내장된 실행자 외 다른 실행자실행 한다. SpringRunner 스프링 실행자 사용 .. Junit <-> 부트테스트 연결
@WebMvcTest                     //여러 스트림 테스트 어노테이션중, Web (Spring MVC) 에 집중 할 수 있다. @Controller, @ControllerAdvice
public class HelloControllerTest {

    @Autowired      //스프링이 관리하는 빈객체 주입
    private MockMvc mvc;        //웹 API 테스트시 사용 , MVC  테스트 시작점, HTTP GET POST API 테스트 가능

    @Test
    public void hello_리턴_테스트() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void hello_dto_가리턴한다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)                    // Api 요청 파라미터 여기서 설정시에는 문자열로 변경해야해
                .param("amount", String.valueOf(amount)))   // 실제 get 요청시에도 문자열로 인자 전달하지 ? 쿼리스트링
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))     //json응답 필드별 검증
                .andExpect(jsonPath("$.amount", is(amount))); // $를 기준으로 필드명
    }
}
package TOYUXTEAM.BOOKSTORE.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    /*
    아래와 같이 Key-Value타입으로 데이터 통신을 하는 경우에 당장에 title, content 같은건 괜찮지만
    User와 같은 객체 데이터를 전송할 때 userId, userName, userLevel 등과 같이 풀어서 나열해야 하기 때문에 표현의 한계가 존재한다.
    -> JSON데이터로 통신한다!!
     */
    @Test
    @DisplayName("/posts 요청시 hello world 출력")
    void keyValueTest() throws Exception {
        mockMvc.perform(post("/keyValue/posts")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "글 제목입니다.")
                        .param("content", "글 내용입니다.")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("/posts 요청시 hello world 출력")
    void jsonTest() throws Exception {
        mockMvc.perform(post("/json/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"제목입니다.\", \"content\" : \"내용입니다\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("/posts 요청시 title값은 필수!")
    void validationTest() throws Exception {
        mockMvc.perform(post("/json/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"\", \"content\" : \"내용입니다\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"))
                .andDo(MockMvcResultHandlers.print());

    }

}
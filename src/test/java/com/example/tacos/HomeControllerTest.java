package com.example.tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class) // тест для HomeController
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // внедряем MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // выполнить запрос get
                .andExpect(status().isOk()) // ожидаем код ответа http 200
                .andExpect(view().name("home")) // ожидаем имя представление home
                .andExpect(content().string( // ожидаем наличие строки
                        containsString("Welcome to...")));
    }

}

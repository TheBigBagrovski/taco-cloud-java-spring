package com.example.tacos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // контроллер
public class HomeController { // ЗАМЕНЕН СТРОКОЙ КОНФИГУРАЦИИ В WEBCONFIG

    @GetMapping("/") // обработка запросов с корневым путем
    public String home() {
        return "home"; // возвращает имя представления
    }

}

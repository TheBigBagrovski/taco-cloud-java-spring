package com.example.tacos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override // метод дял регистрации одного/нескольких контроллеров представлений
    public void addViewControllers(ViewControllerRegistry registry) { // получаем экземпляр ViewControllerRegistry
        // определяет путь в запросах GET по указанному адресу, которые будет обрабатывать этот контроллер
        registry.addViewController("/").setViewName("home"); // заменяет весь класс HomeController
        // метод возвращает объект ViewControllerRegistration для которого мы вызываем setViewname(), указывая имя представления (файл хтмл) которому должны передаваться запросы "/"
        registry.addViewController("/login");
    }

}

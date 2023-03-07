package com.example.tacos.controllers;

import com.example.tacos.models.Ingredient;
import com.example.tacos.models.Ingredient.*;
import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // lombok, добавляет свойство Logger
@Controller
@RequestMapping("/design") // тип запросов, обрабатываемых контроллером (запросы пути который начинаются с /design)
@SessionAttributes("tacoOrder") // объект tacoOrder должен поддерживаться на уровне сессии
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList( // пока нет БД список вшит в код
                new Ingredient("FLTO", "Flour Tortilla", Category.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Category.WRAP),
                new Ingredient("GRBF", "Ground Beef", Category.PROTEIN),
                new Ingredient("CARN", "Carnitas", Category.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Category.VEGGIES),
                new Ingredient("LETC", "Lettuce", Category.VEGGIES),
                new Ingredient("CHED", "Cheddar", Category.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Category.CHEESE),
                new Ingredient("SLSA", "Salsa", Category.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Category.SAUCE)
        );
        Category[] categories = Ingredient.Category.values();
        for (Category category : categories) {
            model.addAttribute(category.toString().toLowerCase(), // чтобы в html через th: обращаться к ингредиентам по типу
                    ingredients.stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList()));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping // метод для обработки GET запросов с путем design
    public String showDesignForm() {
        return "design";
    }

    @PostMapping // обработка post запросов с путем design
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) return "design";
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco); // Logger
        return "redirect:/orders/current";
    }

}

package com.example.tacos.controllers;

import com.example.tacos.data.IngredientRepository;
import com.example.tacos.models.Ingredient;
import com.example.tacos.models.Ingredient.Category;
import com.example.tacos.models.Order;
import com.example.tacos.models.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // lombok, добавляет свойство Logger
@Controller
@RequestMapping("/design") // тип запросов, обрабатываемых контроллером (запросы пути который начинаются с /design)
@SessionAttributes("order") // объект order должен поддерживаться на уровне сессии
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Category[] categories = Category.values();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);
        for (Category category : categories) {
            model.addAttribute(category.toString().toLowerCase(),
                    ingredients.stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList()));
        }
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
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
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) return "design";
        order.addTaco(taco);
        log.info("Processing taco: {}", taco); // Logger
        return "redirect:/orders/current";
    }

}

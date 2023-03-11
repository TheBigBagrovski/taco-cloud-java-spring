package com.example.tacos.controllers;

import com.example.tacos.models.Ingredient;
import com.example.tacos.models.Ingredient.Category;
import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import com.example.tacos.services.IngredientService;
import com.example.tacos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design") // тип запросов, обрабатываемых контроллером (запросы пути который начинаются с /design)
@SessionAttributes("tacoOrder") // объект order должен поддерживаться на уровне сессии
public class DesignTacoController {

    private final IngredientService ingredientService;
    private final OrderService orderService;

    @Autowired
    public DesignTacoController(IngredientService ingredientService, OrderService orderService) {
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Category[] categories = Category.values();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientService.findAll().forEach(ingredients::add);
        for (Category category : categories) {
            model.addAttribute(category.toString().toLowerCase(),
                    ingredients.stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList()));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {
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
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute("tacoOrder") TacoOrder tacoOrder) {
        if (errors.hasErrors()) return "design";
        orderService.processTaco(tacoOrder, taco);
        return "redirect:/orders/current";
    }

}

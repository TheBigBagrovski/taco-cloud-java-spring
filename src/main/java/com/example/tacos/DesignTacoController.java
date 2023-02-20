package com.example.tacos;

import com.example.tacos.Ingredient.Category;
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
@SessionAttributes("tacoOrder") // объект tacoOrder должен поддерживаться на уровне сессии
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

    /*@ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList( // пока нет БД список вшит в код
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), // чтобы в html через th: обращаться к ингредиентам по типу
                    filterByType(ingredients, type));
        }
    }*/

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

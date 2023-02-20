package com.example.tacos;

import com.example.tacos.Ingredient.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // приложение спринг бут
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args); // запуск приложения
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", Category.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Category.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Category.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Category.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Category.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Category.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Category.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Category.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Category.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", Category.SAUCE));
        };
    }

}

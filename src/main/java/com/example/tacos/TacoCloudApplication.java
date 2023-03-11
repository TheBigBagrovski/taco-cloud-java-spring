package com.example.tacos;

import com.example.tacos.data.IngredientRepository;
import com.example.tacos.models.Ingredient;
import com.example.tacos.models.Ingredient.Category;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication // приложение спринг бут
public class TacoCloudApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args); // запуск приложения
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
        registry.addViewController("/admin");
    }

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
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

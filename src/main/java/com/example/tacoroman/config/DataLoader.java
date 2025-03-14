package com.example.tacoroman.config;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.tacoroman.domain.Ingredient;
import com.example.tacoroman.domain.User;
import com.example.tacoroman.domain.Ingredient.Type;
import com.example.tacoroman.domain.Taco;
import com.example.tacoroman.repository.IngredientRepository;
import com.example.tacoroman.repository.TacoRepository;
import com.example.tacoroman.repository.UserRepository;

import lombok.extern.java.Log;

@Log
@Configuration
public class DataLoader {

    @SuppressWarnings("unused")
    @Bean
    public ApplicationRunner chargeData(IngredientRepository ingredientRepo, UserRepository userRepo,TacoRepository tacoRepo,PasswordEncoder encoder) {
        return args -> {
            Ingredient flourTortilla = ingredientRepo.save( new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            Ingredient cornTortilla = ingredientRepo.save( new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            Ingredient groundBeef = ingredientRepo.save( new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            Ingredient carnitas = ingredientRepo.save( new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            Ingredient tomatoes = ingredientRepo.save( new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            Ingredient lettuce = ingredientRepo.save( new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            Ingredient cheddar = ingredientRepo.save( new Ingredient("CHED", "Cheddar", Type.CHEESE));
            Ingredient jack = ingredientRepo.save( new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            Ingredient salsa = ingredientRepo.save( new Ingredient("SLSA", "Salsa", Type.SAUCE));
            Ingredient sourCream = ingredientRepo.save( new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
            
            /*
            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                flourTortilla, 
                groundBeef, 
                carnitas,
                sourCream, 
                salsa, 
                cheddar
                ));


            tacoRepo.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar,jack, sourCream));
            tacoRepo.save(taco2);

            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes,lettuce, salsa));
            tacoRepo.save(taco3);
            */
            User user = new User("user", encoder.encode("user"), "", "", "", "", "", "");
            user.addAuthority("ROLE_USER");
            userRepo.save(user);

            User user2 = new User("user2", encoder.encode("user2"), "", "", "", "", "", "");
            userRepo.save(user2);

            User admin= new User("admin", encoder.encode("admin"), "", "", "", "", "", "");
            admin.addAuthority("ROLE_ADMIN");
            admin.addAuthority("ROLE_USER");
            log.info(admin.getAuthority().toString());
            userRepo.save(admin);
        };
    }
}

package com.example.tacoroman.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.tacoroman.domain.Ingredient;
import com.example.tacoroman.domain.Ingredient.Type;
import com.example.tacoroman.repository.IngredientRepository;

@Component
public class convertStringToIngredient implements Converter<String, Ingredient> {

    private IngredientRepository repo;

    public convertStringToIngredient(IngredientRepository repo) {
        this.repo = repo;
  }

    @Override
    public Ingredient convert(String id) {
        return repo.findById(id).get();
    }
}

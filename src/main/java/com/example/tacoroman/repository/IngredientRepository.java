package com.example.tacoroman.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tacoroman.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{

}

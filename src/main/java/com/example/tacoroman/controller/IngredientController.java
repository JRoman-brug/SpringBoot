package com.example.tacoroman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tacoroman.domain.Ingredient;
import com.example.tacoroman.repository.IngredientRepository;

import lombok.extern.java.Log;

//Para que funcione tuve que desactivar la seguridad y el csrf y habilitar las peticiones de cualquier origen

@Log
@RestController
@RequestMapping("/api/ingredient")
// @CrossOrigin(origins="http:/localhost:8080")
@CrossOrigin(origins="*")
public class IngredientController {

    private IngredientRepository ingredientRepo;

    public IngredientController(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public Iterable<Ingredient> getAllIngredient(){
        return ingredientRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Ingredient getIngredientById(@PathVariable("id") String ingredientId){
        return ingredientRepo.findById(ingredientId).orElse(null);
    }

    //TODO This method has a error when a ingredient its reference by a taco
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteIngredient(@PathVariable("id") String ingredientId) throws Exception{
        log.info("Ingredient deleting... "+ingredientId);
        if(!ingredientRepo.existsById(ingredientId)) throw new Exception("Not exist ingredient");        
        ingredientRepo.deleteById(ingredientId);
    }
}

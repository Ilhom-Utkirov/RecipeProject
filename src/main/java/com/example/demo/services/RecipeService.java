package com.example.demo.services;

import com.example.demo.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe findById(Long id);

    Set<Recipe> getRecipes();
}

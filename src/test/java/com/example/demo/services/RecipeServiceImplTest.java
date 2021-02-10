package com.example.demo.services;

import com.example.demo.domain.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);


    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        //when(recipeService.getRecipes().thenReturn(recipeData));
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(3)).findAll();
    }
}
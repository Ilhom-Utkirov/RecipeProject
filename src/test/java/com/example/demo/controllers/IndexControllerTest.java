package com.example.demo.controllers;

import com.example.demo.domain.Recipe;
import com.example.demo.repositories.RecipeRepository;
import com.example.demo.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Mock
    RecipeRepository recipeRepository;

     @Before
     public void setUp(){
         MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
     }

    @Test
    public void getIndexPAge() throws Exception{
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        //recipes.add(new Recipe()); //problem is this

        /*added to fix the problem above*/
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipes.add(recipe);
        /*added to fix the problem*/

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = controller.getIndexPAge((model));

        assertEquals("index", viewName);//check if returning string from controller is same
        verify(recipeService, times(1)).getRecipes();
        //verify(model, times(1)).addAttribute(eq("recipes"), anySet() );
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture() );
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}
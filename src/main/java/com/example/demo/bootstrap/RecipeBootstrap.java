package com.example.demo.bootstrap;

import com.example.demo.domain.*;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.RecipeRepository;
import com.example.demo.repositories.UnitOfMeasureRepository;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xalan.internal.xsltc.dom.UnionIterator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        //for the beginning only 2 recipes exist
        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMS
        Optional<UnitOfMeasure> eachUOM = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUOM = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUOM = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoonUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> cupUOM = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> pinchUOM = unitOfMeasureRepository.findByDescription("Pinch");
        if(!pinchUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> ounceUOM = unitOfMeasureRepository.findByDescription("Ounce");
        if(!ounceUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> ripeUOM = unitOfMeasureRepository.findByDescription("Ripe");
        if(!ripeUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> dashUOM = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        Optional<UnitOfMeasure> cloveUOM = unitOfMeasureRepository.findByDescription("Clove");
        if(!cloveUOM.isPresent()){
            throw new RuntimeException("Expexted UOM not Found");
        }

        //Now assign declared UOM from database
        //Actually, same as below commented code, but checked one for existence
        //UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByDescription("TeaSpoon").get();
        UnitOfMeasure each = eachUOM.get();
        UnitOfMeasure teaSpoon = teaSpoonUOM.get();
        UnitOfMeasure tableSpoon = tableSpoonUOM.get();
        UnitOfMeasure cup = cupUOM.get();
        UnitOfMeasure pinch = pinchUOM.get();
        UnitOfMeasure ounce = ounceUOM.get();
        UnitOfMeasure ripe = ripeUOM.get();
        UnitOfMeasure dash = dashUOM.get();
        UnitOfMeasure clove = cloveUOM.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast food");
        if(!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Category american = americanCategoryOptional.get();
        Category mexican  = mexicanCategoryOptional.get();
        Category italian  = italianCategoryOptional.get();
        Category fastFood = fastFoodCategoryOptional.get();


        //recioe for guacamole
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setCookTime(10);
        guacamole.setPrepTime(0);
        guacamole.setServings(4);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections(
                "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl."
                +" 2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"
                + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."
                );

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great." +
                "\n"+
                "\n"+
                "Read more at: https://www.simplyrecipes.com/recipes/spicy_three_chile_guacamole/"
        );
        guacNotes.setRecipe(guacamole);

        guacamole.setNotes(guacNotes);

        guacamole.getIngredients().add(new Ingredient("ripe avacados", new BigDecimal(2), each,guacamole));
        guacamole.getIngredients().add(new Ingredient("salt", new BigDecimal(0.2), teaSpoon,guacamole));
        guacamole.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tableSpoon,guacamole));
        guacamole.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoon,guacamole));
        guacamole.getIngredients().add(new Ingredient("chiles, stems and seeds removed, minced", new BigDecimal(2), each,guacamole));
        guacamole.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoon,guacamole));
        guacamole.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dash,guacamole));
        guacamole.getIngredients().add(new Ingredient("tomato, seeds and pulp removed, chopped", new BigDecimal(0.5),ripe,guacamole));
        guacamole.getIngredients().add(new Ingredient("Red radishes or jicama, to garnish", new BigDecimal(1),each,guacamole));
        guacamole.getIngredients().add(new Ingredient("Tortilla chips, to serve", new BigDecimal(1), each,guacamole));

        guacamole.getCategory().add(american);
        guacamole.getCategory().add(mexican);

        recipes.add(guacamole);

        //recipe for Chicken tacos
        Recipe chickenTacos = new Recipe();
        chickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        chickenTacos.setPrepTime(20);
        chickenTacos.setCookTime(15);
        chickenTacos.setServings(4);
        chickenTacos.setDifficulty(Difficulty.MODERATE);

        chickenTacos.setDirections("" +
                "1 Prepare a gas or charcoal grill for medium-high, direct heat."
                + "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over."
                +"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes."
                +"4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                        "\n" +
                        "Wrap warmed tortillas in a tea towel to keep them warm until serving."
                +"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges."
                );

        Notes chickenTacosNotes = new Notes();
        chickenTacosNotes.setRecipeNotes("" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!"
                +"I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                        "\n" +
                        "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                        "\n" +
                        "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!"
                );
        chickenTacosNotes.setRecipe(chickenTacos);
        chickenTacos.setNotes(chickenTacosNotes);

        chickenTacos.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tableSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient(" dried oregano", new BigDecimal(1), teaSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient(" dried cumin", new BigDecimal(1), teaSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient("salt", new BigDecimal(0.5), teaSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient(" garlic, finely chopped", new BigDecimal(1), clove,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), teaSpoon,chickenTacos));
        chickenTacos.getIngredients().add(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", new BigDecimal(5), each,chickenTacos));

        chickenTacos.getCategory().add(italian);
        chickenTacos.getCategory().add(fastFood);

        recipes.add(chickenTacos);


    return  recipes;

    }
}

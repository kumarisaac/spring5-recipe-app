package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientID(Long recipeID, Long ingredientId);
    IngredientCommand save(IngredientCommand ingredientCommand);
    void deleteIngredient(Long recipeId, Long ingredientId);
}

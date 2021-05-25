package guru.springframework.services;

import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest extends TestCase {

    RecipeServiceImpl recipeService;


    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe ;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void testGetRecipes() {
        Recipe recipe = new Recipe();
        recipe.setDescription("Kumar Sambar");
        recipe.setPrepTime(10);
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        for (Recipe recipe1: recipeService.getRecipes())
        {
            assertEquals("Kumar Sambar",recipe1.getDescription());
            assertEquals(new Integer(10),recipe1.getPrepTime());
        }

        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    public void testGetRecipesById() {
        Long id = 2L;
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setDescription("Kumar Sambar");
        recipe.setPrepTime(10);
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeRepository.findById(any())).thenReturn(Optional.of(recipe));

        Recipe returnRecipe = recipeService.findById(2L);

        assertEquals("Kumar Sambar",returnRecipe.getDescription());
        assertEquals(new Integer(10),returnRecipe.getPrepTime());

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }

}
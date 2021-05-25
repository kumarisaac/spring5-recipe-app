package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest extends TestCase {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
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

    }
}
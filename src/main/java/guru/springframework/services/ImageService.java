package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import org.springframework.web.multipart.MultipartFile;



public interface ImageService {
    RecipeCommand getRecipeImage(Long recipeId);
    void UploadImage(MultipartFile file, Long recipeId);
}

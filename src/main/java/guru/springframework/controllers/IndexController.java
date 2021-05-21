package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index", "index.html"})
    public String getIndexPage(){

        Category category = categoryRepository.findByCategoryName("American").get();

        System.out.println(category.getId());
        System.out.println(unitOfMeasureRepository.findByDescription("Tablespoon").get().getId());
        return "index";

    }

}

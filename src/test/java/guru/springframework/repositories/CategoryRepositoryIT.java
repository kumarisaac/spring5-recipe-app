package guru.springframework.repositories;

import guru.springframework.domain.Category;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIT {

    @Autowired
    CategoryRepository categoryRepository;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByCategoryName() {
        Optional<Category> categoryOptional = categoryRepository.findByCategoryName("American");
        assertEquals("American", categoryOptional.get().getCategoryName());
    }

    @Test
    public void findByCategorySize(){
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        assertEquals(4, categories.size());
    }

    @Test
    public void findByIdMexican(){
        Optional<Category> category = categoryRepository.findById(3L);
        assertEquals("Mexican", category.get().getCategoryName());
    }
}
package guru.springframework.domain;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest extends TestCase {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void testGetId() {
        Long aLong = 2L;
        category.setId(aLong);
        assertEquals(aLong, category.getId());
    }

    @Test
    public void testGetCategoryName() {
    }
}
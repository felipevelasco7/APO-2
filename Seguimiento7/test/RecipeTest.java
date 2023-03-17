package test;

import exceptions.WeightException;
import junit.framework.TestCase;
import model.Recipe;


public class RecipeTest extends TestCase{
    private Recipe recipe;

    public void setupStage1(){
        recipe = new Recipe();
    }

    public void setupStage2(){
        setupStage1();
        try {
            recipe.addIngredient("Cebolla", 315);
            recipe.addIngredient("Ajo", 58);
            recipe.addIngredient("Arroz", 520);
        } catch (WeightException e) {
            System.out.println(e);        
        }

    }

    public void testAddIngredient(){
        setupStage1();
        try {
            recipe.addIngredient("Sal", 12);
            assertEquals(12,  recipe.getIngredients().get(0).getWeight());
            assertEquals("Sal", recipe.getIngredients().get(0).getName());
            assertEquals(1, recipe.getIngredients().size());

        } catch (WeightException e) {
            System.out.println(e);
        }
    }

    public void testAddIngredient2(){
        setupStage2();
        try {
            recipe.addIngredient("Pimienta", 6);
            assertEquals(6,  recipe.getIngredients().get(3).getWeight());
            assertEquals("Pimienta", recipe.getIngredients().get(3).getName());
            assertEquals(4, recipe.getIngredients().size());

        } catch (WeightException e) {
            System.out.println(e);
        }
    }

    public void testAddIngredient3(){
        setupStage2();
        try {
            recipe.addIngredient("Ajo", 21);
            assertEquals(21,  recipe.getIngredients().get(1).getWeight());
            assertEquals("Ajo", recipe.getIngredients().get(1).getName());
            assertEquals(3, recipe.getIngredients().size());

        } catch (WeightException e) {
            System.out.println(e);
        }
    }
    public void testRemoveIngredient(){
        setupStage2();
        
        recipe.removeIngredient("Ajo");
        
        assertEquals(2, recipe.getIngredients().size());
        assertEquals("Cebolla", recipe.getIngredients().get(0).getName());
        assertEquals("Arroz", recipe.getIngredients().get(1).getName());

       
    }
}

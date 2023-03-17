package test;
import exceptions.WeightException;
import junit.framework.TestCase;
import model.Ingredient;


public class IngredientTest extends TestCase{
    private Ingredient ingredient;

    public void setupStage1(){
        try {
            ingredient = new Ingredient("Tomate",245);
        } catch (WeightException e) {
            System.out.println(e);
        }
    }

    public void testAddWeight(){
        setupStage1();
        try {
            ingredient.addWeight(54);
            assertEquals(299, ingredient.getWeight());

            
        } catch (WeightException e) {
            System.out.println(e);
        }
    }

    public void testAddWeight2(){
        setupStage1();
        try {
            ingredient.addWeight(-100);
            
        } catch (WeightException e) {
            System.out.println(e);
            assertEquals(245, ingredient.getWeight());
        }
    }

    public void testRemoveWeight(){
        setupStage1();
        try {
            ingredient.removeWeight(45);
            assertEquals(200, ingredient.getWeight());

            
        } catch (WeightException e) {
            System.out.println(e);
        }
    }
    public void testRemoveWeight2(){
        setupStage1();
        try {
            ingredient.removeWeight(-100);
            
        } catch (WeightException e) {
            System.out.println(e);
            assertEquals(245, ingredient.getWeight());
        }
    }
}

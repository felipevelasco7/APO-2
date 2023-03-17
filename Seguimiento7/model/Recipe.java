package model;
import exceptions.WeightException;
import java.util.ArrayList;


public class Recipe {
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    


    public Recipe() {
        ingredients = new ArrayList<>();
    }

    
    public void addIngredient(String name, int weight)throws WeightException{
        if(weight<0){
            throw new WeightException("no se pueden usar números negativos.");
        }
        boolean exists=false;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                ingredient.setWeight(weight);
                exists=true;
                break;
            }
        }
        if(!exists)ingredients.add(new Ingredient(name, weight));
    }

    public void removeIngredient(String name){
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                ingredients.remove(ingredient);
                break;
            }
        }
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }


    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

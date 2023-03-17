package model;

import exceptions.WeightException;

public class Ingredient {

    private String name;
    private int weight;

    public Ingredient(String name, int weight) throws WeightException {
        if(weight<0){
            throw new WeightException("no se pueden usar números negativos.");
        }
        this.name = name;
        this.weight = weight;
    }

    public void addWeight(int add) throws WeightException{
        if(add<0){
            throw new WeightException("no se pueden usar números negativos.");
        }
        this.weight+=add;
    }
    public void removeWeight(int remove)throws WeightException{
        if(remove<0){
            throw new WeightException("no se pueden usar números negativos.");
        }
        this.weight= weight-remove;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
}
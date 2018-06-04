package ch.bbcag.foodwizard.Model;

public class Ingredient {

    private String name;
    private String measure;


    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }



    public Ingredient(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

package ch.bbcag.foodwizard.Model;

import java.util.ArrayList;

public class Meal {


    private String mId;
    private String category;
    private String instructions;
    private String mName;


    public Meal() {

    }

    public Meal(String mId, String category, String instructions, String mName, String country, String image) {
        this.mId = mId;
        this.category = category;
        this.instructions = instructions;
        this.mName = mName;
        this.country = country;
        this.image = image;
    }

    private String country;
    private ArrayList<Ingredient> ingredientsList = new ArrayList<>();
    private String image;





    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addIngredient(Ingredient ingredient ){
        ingredientsList.add(ingredient);
    }




}

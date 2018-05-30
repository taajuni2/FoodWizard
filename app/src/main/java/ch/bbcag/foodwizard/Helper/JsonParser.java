package ch.bbcag.foodwizard.Helper;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import ch.bbcag.foodwizard.Model.Ingredient;
import ch.bbcag.foodwizard.Model.Meal;

public class JsonParser {

    public static Meal createMealFromJson(String mealJsonString) throws JSONException{
        Meal meal = new Meal();
        JSONObject jsonObj = new JSONObject(mealJsonString);
        meal.setmId(jsonObj.getInt("idMeal"));
        meal.setmName(jsonObj.getString("strMeal"));
        meal.setCategory(jsonObj.getString("strCategory"));
        meal.setInstructions(jsonObj.getString("strInstructions"));
        meal.setImage(jsonObj.getString("strMealThumb"));
        meal.setCountry(jsonObj.getString("strArea"));
        Ingredient ingredient = new Ingredient();
        for(int i = 1; i <= 20; i++){
            Log.v("ingredient" + i, jsonObj.getString("strIngredient" + i));




//            meal.getIngredientsList(ingredient.getName());

        }
        return meal;
    }
}

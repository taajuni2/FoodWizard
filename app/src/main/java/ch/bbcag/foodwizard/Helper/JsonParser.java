package ch.bbcag.foodwizard.Helper;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import ch.bbcag.foodwizard.Model.Ingredient;
import ch.bbcag.foodwizard.Model.Meal;

public class JsonParser {


    public static List<Meal> createMealFromJson(String mealJsonString) throws JSONException {
        JSONObject jsonObj = new JSONObject(mealJsonString);
        JSONArray js = jsonObj.getJSONArray("meals");

        List<Meal> mealList = new ArrayList<>();
        for (int i = 0; i < js.length(); i++) {

            Meal meal = new Meal();
            JSONObject jsonMeal = js.getJSONObject(i);

            //  Ingredient test = new Ingredient(jsonMeal.getString("strIngredient"));

            meal.setmId(jsonMeal.getString("idMeal"));
            meal.setmName(jsonMeal.getString("strMeal"));
            meal.setCountry(jsonMeal.getString("strArea"));
            meal.setImage(jsonMeal.getString("strMealThumb"));
            meal.setInstructions(jsonMeal.getString("strInstructions"));

            parseIngredients(jsonMeal, meal);

            mealList.add(meal);
        }
        return mealList;
    }



    private static void parseIngredients(JSONObject jsonMeal, Meal meal) {

        for (int k = 1; k < 20; k++) {
            Ingredient ingredient = null;

            try {
                if(ingredient.getName() == ""){
                    ingredient = new Ingredient(jsonMeal.getString("strIngredient" + k));
                    meal.addIngredient(ingredient);
                }else{

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }





    }




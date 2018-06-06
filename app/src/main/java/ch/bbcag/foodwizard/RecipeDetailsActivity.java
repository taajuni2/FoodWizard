package ch.bbcag.foodwizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.IOException;

import ch.bbcag.foodwizard.Helper.RVAdapterRecipeDetails;
import ch.bbcag.foodwizard.Model.Meal;


public class RecipeDetailsActivity extends AppCompatActivity {
    static Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ObjectMapper mapper = new ObjectMapper();
        String menuJson = getIntent().getStringExtra("mealJson");
        try {

            meal = mapper.readValue(menuJson, Meal.class);

        }catch (IOException e) {
            e.printStackTrace();
        }
        writeDetails();
    }

    public void writeDetails(){
        RVAdapterRecipeDetails adapter = new RVAdapterRecipeDetails(meal);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView detailsView =  findViewById(R.id.details_recycler_view);
        detailsView.setLayoutManager(layoutManager);
        detailsView.setAdapter(adapter);
    }
}
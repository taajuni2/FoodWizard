package ch.bbcag.foodwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.w3c.dom.Text;

import java.io.IOException;

import ch.bbcag.foodwizard.Helper.RVAdapterRecipeDetails;
import ch.bbcag.foodwizard.Model.Meal;


public class RecipeDetailsActivity extends AppCompatActivity {
    static Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        TextView recipename = findViewById(R.id.recipe_name);

        TextView instructions = findViewById(R.id.recipe_instruction);
        instructions.setMovementMethod(new ScrollingMovementMethod());
        instructions.setText(meal.getInstructions());
        recipename.setText(meal.getName());
        detailsView.setLayoutManager(layoutManager);
        detailsView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), ReceptActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
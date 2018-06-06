package ch.bbcag.foodwizard;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.util.List;

import ch.bbcag.foodwizard.Helper.RVAdapter;
import ch.bbcag.foodwizard.Model.Meal;

import static ch.bbcag.foodwizard.Helper.JsonParser.createMealFromJson;


public class ReceptActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    String searchString;


    private static final String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recept);
        progressBar = findViewById(R.id.loading_recept_progress);
        searchString = getIntent().getStringExtra("searchString");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMenues(URL + searchString);


    }

    private void getMenues(String url) {
        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    List<Meal> happymeals = createMealFromJson(response);
                    RecyclerView recipeRecyclerView = findViewById(R.id.recipe_recycler_view);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    RVAdapter adapter = new RVAdapter(happymeals);

                    recipeRecyclerView.setLayoutManager(layoutManager);
                    recipeRecyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);


                } catch (JSONException e) {
                    generateAlertDialog();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                generateAlertDialog();
            }

        });
        queue.add(stringRequest);
    }


    private void generateAlertDialog() {
        progressBar.setVisibility(View.GONE);
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        dialogBuilder.setMessage(" An error has occurred in the backend at the moment.").setTitle("Error!!!");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }


    public void switchToDetails(View view) {
        Intent details = new Intent(getApplicationContext(), RecipeDetailsActivity.class);
        Meal meal = ((Meal)view.getTag());
        ObjectMapper mapper = new ObjectMapper();
        try {
            Log.v("mealJson", mapper.writeValueAsString(meal));
            details.putExtra("mealJson" , mapper.writeValueAsString(meal));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


//        details.putStringExtra("mealJson",view.getTag().);
        startActivity(details);
    }
}


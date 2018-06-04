package ch.bbcag.foodwizard;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;


import org.json.JSONException;

import ch.bbcag.foodwizard.Helper.JsonParser;
import ch.bbcag.foodwizard.Model.Ingredient;
import ch.bbcag.foodwizard.Model.Meal;

import static ch.bbcag.foodwizard.Helper.JsonParser.createMealFromJson;

public class ReceptDetailsActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int mId;

    private static final String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recept_details);
        progressBar = findViewById(R.id.loading_recept_details_progress);
        getMenu(URL + "Garlic");
    }

//    public void test() {
//        ArrayAdapter<Meal> mealAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
//        mealAdapter.add(new Meal());
//        Button bt = findViewById(R.id.test_button);
//        ListView items = findViewById(R.id.test_list);
//        items.setAdapter(mealAdapter);
//
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ReceptDetailsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void getMenu(String url){
        final ArrayAdapter<Ingredient> ingredientAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               try {
                   Meal happymeal = (Meal) createMealFromJson(response);
                   ingredientAdapter.addAll(happymeal.getIngredientsList());
                   ListView iItems = findViewById(R.id.test_list);
                   iItems.setAdapter(ingredientAdapter);
                   progressBar.setVisibility(View.GONE);


               }catch(JSONException e){
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
        dialogBuilder.setMessage("Leider ist ein Fehler aufgetretten bitte löschen Sie unser App LG Developer.").setTitle("Fehler");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}


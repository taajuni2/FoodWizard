package ch.bbcag.foodwizard;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import org.json.JSONException;


import java.util.ArrayList;
import java.util.List;


import ch.bbcag.foodwizard.Model.Meal;

import static ch.bbcag.foodwizard.Helper.JsonParser.createMealFromJson;

public class ReceptActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private static final ArrayList<Meal> meals = new ArrayList<>();

    private static final String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recept);
        progressBar = findViewById(R.id.loading_recept_progress);
        getMenues(URL + "Garlic");
    }


    private void getMenues(String url){
        final ArrayAdapter<Meal> mealAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               try {
                   List<Meal> happymeals =  createMealFromJson(response);
                   mealAdapter.addAll(happymeals);
                   ListView iItems = findViewById(R.id.test_list);
                   iItems.setAdapter(mealAdapter);
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

    private void displayData(ArrayList<Meal> meals){
        TextView rezept = new TextView(getApplicationContext());



    }
}


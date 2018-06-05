package ch.bbcag.foodwizard;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

<<<<<<< HEAD

=======
>>>>>>> justin-dev
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.MenuItem;
=======
>>>>>>> justin-dev
import android.view.View;

import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.util.List;


import ch.bbcag.foodwizard.Model.Meal;

import static ch.bbcag.foodwizard.Helper.JsonParser.createMealFromJson;
import static ch.bbcag.foodwizard.Helper.RVAdapter.*;

public class ReceptActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    public String wish;
    String searchString;

    public void setWish(String wish) {
        this.wish = wish;
    }

   



    private static final String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recept);
        progressBar = findViewById(R.id.loading_recept_progress);
        searchString = getIntent().getStringExtra("searchString");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getMenues(URL + searchString);

    }

//        final ArrayAdapter<Meal> mealAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);

        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
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
        dialogBuilder.setMessage("Fatal Error!! kaufen sie ein neues Handy.").setTitle("Fehler");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

<<<<<<< HEAD



=======
    private void displayData(ArrayList<Meal> meals) {
        TextView rezept = new TextView(getApplicationContext());


    }
>>>>>>> justin-dev
}


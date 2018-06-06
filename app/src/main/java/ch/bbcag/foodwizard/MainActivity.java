package ch.bbcag.foodwizard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    String searchString;
    public boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        addToList();


    }


    public void addToList() {

        final EditText searchInput = findViewById(R.id.input_search);
        final Button findRecipe = findViewById(R.id.find_recipe);
        final ListView view = findViewById(R.id.zutatenView);
        final ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.ingredient_list_item, R.id.ingredient_list_item);
        view.setAdapter(searchAdapter);

        findRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchString = searchInput.getText().toString();
                if (searchString.isEmpty() == true) {
                    generateAlert();
                } else {
                    searchAdapter.add(searchString);
                    Intent intent = new Intent(getApplicationContext(), ReceptActivity.class);
                    intent.putExtra("searchString", searchString);
                    startActivity(intent);
                    check = true;
                }


            }
        });


    }

    private void generateAlert() {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                releaseInstance();
            }
        });
        dialogBuilder.setMessage("No ingredient was entered! Please enter an ingredient!").setTitle("Error!!!");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }


}

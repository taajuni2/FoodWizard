package ch.bbcag.foodwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addToList();


    }


    public void addToList() {

        final EditText searchInput = findViewById(R.id.input_search);
        final Button button = findViewById(R.id.button_send);
        final Button findRecipe = findViewById(R.id.find_recipe);
        final ListView view = findViewById(R.id.zutatenView);
        final ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.ingredient_list_item, R.id.ingredient_list_item);
        view.setAdapter(searchAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchString = searchInput.getText().toString();

                searchAdapter.add(searchString);

            }
        });

        findRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReceptActivity.class);
                startActivity(intent);
            }
        });
    }

    /*public void redirectToRecept() {
        ListView items = findViewById(R.id.test_list);
        ArrayAdapter<Meal> mealAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        mealAdapter.add(new Meal());
        Button bt = findViewById(R.id.find_recipe);
        items.setAdapter(mealAdapter);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReceptActivity.class);
                startActivity(intent);

            }
        });


    }
*/


}

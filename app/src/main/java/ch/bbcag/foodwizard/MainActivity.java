package ch.bbcag.foodwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import ch.bbcag.foodwizard.Model.Meal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();


    }


    public void test() {
        ListView items = findViewById(R.id.test_list);
        ArrayAdapter<Meal> mealAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        mealAdapter.add(new Meal());
        Button bt = findViewById(R.id.test_button);
        items.setAdapter(mealAdapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReceptDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}

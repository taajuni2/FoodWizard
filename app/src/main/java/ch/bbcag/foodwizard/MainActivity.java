package ch.bbcag.foodwizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List search = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView schgumpe = findViewById(R.id.schgumpälämpemachetue);
        Button searchInput = findViewById(R.id.button_send);

        searchInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ArrayAdapter<ingredeats> ingredeatsArray = new ArrayAdapter<>();

            }
        });
    }


}

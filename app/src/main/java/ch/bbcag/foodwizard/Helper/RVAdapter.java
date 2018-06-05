package ch.bbcag.foodwizard.Helper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.bbcag.foodwizard.Model.Meal;
import ch.bbcag.foodwizard.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.HappyMealHolder>{

    public static class HappyMealHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView mealName;
        TextView catagory;
        ImageView personPhoto;


        public HappyMealHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            mealName = (TextView) itemView.findViewById(R.id.meal_name);
            catagory = (TextView) itemView.findViewById(R.id.meal_catagory);
            personPhoto = (ImageView) itemView.findViewById(R.id.meal_picture);
        }
    }

    private List<Meal> happyMeals;

    RVAdapter(List<Meal> happyMeals) {
        this.happyMeals = happyMeals;
    }



}

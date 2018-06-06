package ch.bbcag.foodwizard.Helper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ch.bbcag.foodwizard.Model.Meal;
import ch.bbcag.foodwizard.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.HappyMealHolder>{


    public static class HappyMealHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        CardView cardView;
        TextView mealName;
        TextView mealCategory;
        ImageView happyMealPhoto;


        public HappyMealHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recipe_recycler_view);
            cardView = itemView.findViewById(R.id.cv);
            mealName = (TextView) itemView.findViewById(R.id.meal_name);
            mealCategory = (TextView) itemView.findViewById(R.id.meal_category);
            happyMealPhoto = (ImageView) itemView.findViewById(R.id.meal_picture);

        }


    }

    public List<Meal> happyMeals;



    public RVAdapter(List<Meal> happyMeals) {
        this.happyMeals = happyMeals;
    }

    @Override
    public int getItemCount() {
        return happyMeals.size();
    }

    @Override
    public HappyMealHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_card, viewGroup, false);
        HappyMealHolder hmh = new HappyMealHolder(v);
        return hmh;
    }

    @Override
    public void onBindViewHolder(HappyMealHolder happyMealHolder, int i) {

        happyMealHolder.cardView.setTag(happyMeals.get(i));
        happyMealHolder.mealName.setText(happyMeals.get(i).getName());
        happyMealHolder.mealCategory.setText(happyMeals.get(i).getCategory());
        Picasso.get().load(happyMeals.get(i).getImage()).into(happyMealHolder.happyMealPhoto);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}

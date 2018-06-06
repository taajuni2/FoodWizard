package ch.bbcag.foodwizard.Helper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

<<<<<<< HEAD:app/src/main/java/ch/bbcag/foodwizard/Helper/RVAdapterRecipeDetails.java

=======

>>>>>>> justin-dev:app/src/main/java/ch/bbcag/foodwizard/Helper/RVAdaterRecipeDetails.java
import java.util.List;

import ch.bbcag.foodwizard.Model.Ingredient;
import ch.bbcag.foodwizard.Model.Meal;
import ch.bbcag.foodwizard.R;

public  class RVAdapterRecipeDetails extends RecyclerView.Adapter<RVAdapterRecipeDetails.DetailsHolder> {


    public static class DetailsHolder extends RecyclerView.ViewHolder {

        public static  String Url = "https://www.themealdb.com/images/ingredients/";
        public static   String imgType = ".png";
        CardView cv;
        TextView ingredient;
        TextView measure;
        ImageView ingredientPicture;


        public DetailsHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.details_recycler_view);
            ingredient = (TextView) itemView.findViewById(R.id.details_ingredient);
            measure = (TextView) itemView.findViewById(R.id.ingredient_mesuere);
            ingredientPicture = (ImageView) itemView.findViewById(R.id.ingredient_picture);
        }
    }

    public List<Ingredient> ingredients;

<<<<<<< HEAD:app/src/main/java/ch/bbcag/foodwizard/Helper/RVAdapterRecipeDetails.java
    public RVAdapterRecipeDetails(Meal meal) {
=======
    public RVAdaterRecipeDetails( Meal meal) {

>>>>>>> justin-dev:app/src/main/java/ch/bbcag/foodwizard/Helper/RVAdaterRecipeDetails.java
            ingredients = meal.getIngredientsList();
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    @Override
    public DetailsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.details_recipe, viewGroup, false);
        DetailsHolder dh = new DetailsHolder(v);
        return dh;
    }

    @Override
    public void onBindViewHolder(DetailsHolder detailsHolder, int i) {

        final String Url = "https://www.themealdb.com/images/ingredients/";
        final String imgType = ".png";
        detailsHolder.measure.setText(ingredients.get(i).getMeasure());
        detailsHolder.ingredient.setText(ingredients.get(i).getName());
        Picasso.get().load(Url + ingredients.get(i).getName().toString() + imgType).into(detailsHolder.ingredientPicture);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}

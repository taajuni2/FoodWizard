package ch.bbcag.foodwizard.Helper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import ch.bbcag.foodwizard.Model.Ingredient;
import ch.bbcag.foodwizard.Model.Meal;
import ch.bbcag.foodwizard.R;

public abstract class RVAdaterRecipeDetails extends RecyclerView.Adapter<RVAdaterRecipeDetails.DetailsHolder> {


    public static class DetailsHolder extends RecyclerView.ViewHolder {

        public static  String Url = "https://www.themealdb.com/images/ingredients/";
        public static   String imgType = ".png";
        CardView cv;
        TextView ingredient;
        TextView mesuer;
        ImageView ingredientPicture;


        public DetailsHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.details_recycler_view);
            ingredient = (TextView) itemView.findViewById(R.id.details_ingredient);
            mesuer = (TextView) itemView.findViewById(R.id.ingredient_mesuere);
            ingredientPicture = (ImageView) itemView.findViewById(R.id.ingredient_picture);
        }
    }

    public List<Ingredient> ingredients;

    public RVAdaterRecipeDetails( Meal meal) {

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
        detailsHolder.mesuer.setText(ingredients.get(i).getMeasure());
        detailsHolder.ingredient.setText(ingredients.get(i).getName());
        Picasso.get().load(Url + ingredients.get(i).getName() + imgType).into(detailsHolder.ingredientPicture);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}

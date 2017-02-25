package truiton.cardview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by melod on 24.02.2017.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    private Fragment fragment;
    private List<Recipes> recipesList;

    public class RecipesViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView name;
        public ImageView recipesPhoto;
        public View itemView;


        public RecipesViewHolder(View view) {
            super(view);
            itemView = view;
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            name = (TextView) itemView.findViewById(R.id.recipes_name);
            recipesPhoto = (ImageView) itemView.findViewById(R.id.recipes_photo);


        }

    }

    public RecipesAdapter(List<Recipes> recipesList, Fragment fragment) {
        this.recipesList = recipesList;
        this.fragment = fragment;
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipes_list, parent, false);

        return new RecipesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        Recipes recipes = recipesList.get(position);
        holder.name.setText(recipes.getName());
        holder.recipesPhoto.setImageResource(recipes.getIdPhoto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) fragment.getActivity();
                activity.showDetails();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

}


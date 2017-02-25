package truiton.cardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment extends android.support.v4.app.Fragment {


    private List<Recipes> recipesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecipesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        prepareRecipesData();
        RecipesAdapter mAdapter = new RecipesAdapter(recipesList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        prepareRecipesData();

    }

    private void prepareRecipesData() {

        Recipes recipes = new Recipes("Salat",R.drawable.salat);
        recipesList.add(recipes);
        Recipes recipes1 = new Recipes("Chicken", R.drawable.chicken);
        recipesList.add(recipes1);



    }
}

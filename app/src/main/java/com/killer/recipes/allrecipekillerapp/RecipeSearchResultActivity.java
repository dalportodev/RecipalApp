package com.killer.recipes.allrecipekillerapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RecipeSearchResultActivity extends AppCompatActivity {

    RecipeDataSource myDs;
    ArrayList<ArrayList<String>> Ingredients = new ArrayList<>();
    ArrayList<String> foundRecipes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_search_result);
        myDs = new RecipeDataSource(this);

        ArrayList<String> strTokens;
        for (int i = 0; i < myDs.getIngredientPool().size(); i++) {
            strTokens = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(myDs.getIngredientPool().get(i));
            while(st.hasMoreTokens()) {
                strTokens.add(st.nextToken());
            }
            Ingredients.add((ArrayList<String>) strTokens.clone());
        }

        Bundle bun = getIntent().getExtras();
        TextView Recipes = (TextView)findViewById(R.id.textViewIngSrchResults);
        if (bun != null) {
            String ing1 = bun.getString("Ingredient1");
            String ing2 = bun.getString("Ingredient2");
            String ing3 = bun.getString("Ingredient3");
            String ing4 = bun.getString("Ingredient4");
            for (int i = 0; i < Ingredients.size(); i++) {
                if (Ingredients.get(i).contains(ing1) || Ingredients.get(i).contains(ing2) || Ingredients.get(i).contains(ing3) || Ingredients.get(i).contains(ing4)) {
                    //Recipes.setText(Recipes.getText() + " " + myDs.getRecipePool().get(i));
                    foundRecipes.add(myDs.getRecipePool().get(i));
                }
            }
        }
    }

    /*

    String A = getIntent().getStringExtra("Ingredient1");
        String B = getIntent().getStringExtra("Ingredient2");
        String C = getIntent().getStringExtra("Ingredient3");
        String D = getIntent().getStringExtra("Ingredient4");
        TextView tv1 = (TextView) findViewById(R.id.TVIngredient);
        TextView tv2 = (TextView) findViewById(R.id.TVIngredient2);
        TextView tv3 = (TextView) findViewById(R.id.TVIngredient3);
        TextView tv4 = (TextView) findViewById(R.id.TVIngredient4);
        Log.d("TAG", tv1.toString());
        tv1.setText(A + ",");
        tv2.setText(B + ",");
        tv3.setText(C + ",");
        tv4.setText(D);


        String[] recipe1 = getResources().getStringArray(R.array.Recipe1);
        String[] recipe2 = getResources().getStringArray(R.array.Recipe2);
        String[] recipe3 = getResources().getStringArray(R.array.Recipe3);
        String[] recipe4 = getResources().getStringArray(R.array.Recipe4);
        String[] recipe5 = getResources().getStringArray(R.array.Recipe5);
        String[] ingredients = {A, B, C, D};

        if (Arrays.asList(recipe1).containsAll(Arrays.asList(ingredients))) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe1));
        }
        else if (Arrays.asList(recipe2).containsAll(Arrays.asList(ingredients))) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe2));
        }
        else if (Arrays.asList(recipe3).containsAll(Arrays.asList(ingredients))) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe3));
        }
        else if (Arrays.asList(recipe4).containsAll(Arrays.asList(ingredients))) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe4));
        }
        else if (Arrays.asList(recipe5).containsAll(Arrays.asList(ingredients))) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe5));
        }
        else {
            String message = "No activity_recipe_search_result found";
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(message);
        }
        /*  From Here
        for (int j = 0; j <= ingredients.length; j++) {
            while (i < recipe1.length) {
                if (Arrays.asList(recipe1[i]).contains(ingredients[j])) {
                    count1 = count1 + 1;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
            while (i < recipe2.length) {
                if (Arrays.asList(recipe2[i]).contains(ingredients[j])) {
                    count2 = count2 + 1;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
            while (i < recipe3.length) {
                if (Arrays.asList(recipe3[i]).contains(ingredients[j])) {
                    count3 = count3 + 1;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
            while (i < recipe4.length) {
                if (Arrays.asList(recipe4[i]).contains(ingredients[j])) {
                    count4 = count4 + 1;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
            while (i < recipe5.length) {
                if (Arrays.asList(recipe5[i]).contains(ingredients[j])) {
                    count5 = count5 + 1;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
        }
        if (count1 > 3) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe1));
        } else if (count2 > 3) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe2));
        } else if (count3 > 3) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe3));
        } else if (count4 > 3) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe4));
        } else if (count5 > 3) {
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(Arrays.toString(recipe5));
        } else {
            String message = "No activity_recipe_search_result found";
            TextView recipePrint = (TextView) findViewById(R.id.Recipe);
            recipePrint.setText(message);
        } To Here
        */
    /*
    **********************
    public void viewRecipeDirections(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityRecipeSearchRe);
        Bundle bund = new Bundle();
        bund.putString("ingredients", this.ingredients);
        bund.putString("directions", this.directions);
        bund.putString("title", this.recipeName);
        intent.putExtras(bund);
        startActivity(intent);
    }*/

}

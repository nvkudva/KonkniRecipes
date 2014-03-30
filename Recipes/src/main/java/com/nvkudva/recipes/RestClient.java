package com.nvkudva.recipes;

import com.nvkudva.recipes.dao.Plate;
import retrofit.RestAdapter;
import retrofit.http.GET;

import java.util.List;

public class RestClient {
    private static RestClient instance = null;
    private static final String MONGO_KEY="?apiKey=w1KeF3ei_CIB9G94huxJSmazss1anGJd";
    private static final String MONGO_URL = "https://api.mongolab.com/api/1/databases/recipedb";
    private static RestAdapter recipedbAdapter;

    public Recipe recipe;

    RestClient(){
        recipedbAdapter = new RestAdapter.Builder().setEndpoint(MONGO_URL).build();
        recipe = recipedbAdapter.create(Recipe.class);

    }
    public static RestClient getInstance() {
        if(instance == null) {
            instance = new RestClient();
        }
        return instance;
    }
    interface Recipe {
        @GET("/collections/plate"+ MONGO_KEY)
        List<Plate> getPlates();
    }

}

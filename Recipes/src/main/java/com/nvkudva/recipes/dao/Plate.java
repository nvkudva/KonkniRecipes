package com.nvkudva.recipes.dao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vijaykrishna on 30/03/14.
 */
public class Plate implements Serializable{
    public String name;
    public String konkaniName;
    public String preperationTime;
    public String serveCount;
    public String type;
    public String likes;

    public ArrayList<String> categories;
    public ArrayList<String> tags;
    public ArrayList<String> contributors;
    public ArrayList<Ingredient> ingredients;
    public ArrayList<String> directions;

}



package com.nvkudva.recipes.dao;

import java.io.Serializable;

/**
 * Created by vijaykrishna on 30/03/14.
 */
public class Ingredient implements Serializable{
    public String item;
    public String size;
    public String quantity;

    @Override
    public String toString(){
        return item+ "\t:"+ quantity;
    }
}
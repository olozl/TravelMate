package com.lee.zoey.travelmate;

/**
 * Created by user1 on 2017-07-11.
 */

import android.graphics.drawable.Drawable;

import android.graphics.drawable.Drawable;

public class Product {

    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Product(String title, Drawable productImage) {
        this.title = title;
        this.productImage = productImage;
    }

    public Product(String title, Drawable productImage, String description,
                   double price) {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object o){
        if(this.title.equals(((Product)o).title)) return true;
        return false;
    }

    public String getTitle(){
        return title;
    }

}
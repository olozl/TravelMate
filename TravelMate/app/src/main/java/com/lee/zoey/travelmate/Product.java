package com.lee.zoey.travelmate;


/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

import android.graphics.drawable.Drawable;

import android.graphics.drawable.Drawable;

public class Product {

    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    // Constructor for City catagory
    public Product(String title, Drawable productImage) {
        this.title = title;
        this.productImage = productImage;
    }

    // Constructor for travel plan in a certain city
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
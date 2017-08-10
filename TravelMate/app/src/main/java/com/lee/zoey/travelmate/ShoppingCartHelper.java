package com.lee.zoey.travelmate;


/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
    private static Map<Product, Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();


    public static void setCity(Resources res, String CityName, String PlanName,
                                                String PlanDescription, float price){
        catalog.put(new Product(CityName, res.getDrawable(R.drawable.ic_action_name)),
                new Product(PlanName, res.getDrawable(R.drawable.ic_action_name),
                        PlanDescription, price));
    }
    // Mapping travel plans for each city
    public static Map<Product, Product> getCity(Resources res){
        if(catalog == null) {
            catalog = new HashMap<Product, Product>();
            catalog.put(new Product("Portland", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Bike Tour", res.getDrawable(R.drawable.ic_action_name),
                            "PSU tour (1hr) + Downtown Tour (3hrs) ", 30.00));
            catalog.put(new Product("Portland", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Mt. Hood Tour", res.getDrawable(R.drawable.ic_action_name),
                            "PSU tour (1hr) + Downtown Tour (3hrs) ", 30.00));
            catalog.put(new Product("Portland", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("PSU Tour", res.getDrawable(R.drawable.ic_action_name),
                            "2hrs", 10.00));

            catalog.put(new Product("New York", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Times Square Tour", res.getDrawable(R.drawable.ic_action_name),
                            "One day bus trip (8hrs)", 45.00));
            catalog.put(new Product("New York", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Helicopter Tour", res.getDrawable(R.drawable.ic_action_name),
                            "Downtown (1hr)", 200.00));
            catalog.put(new Product("LasVegas", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Helicopter Tour", res.getDrawable(R.drawable.ic_action_name),
                            "Helicopter Flight at Night over the Las Vegas Strip (30min)", 100.00));
            catalog.put(new Product("Chicago", res.getDrawable(R.drawable.ic_action_name)),
                    new Product("Grant Park Tour", res.getDrawable(R.drawable.ic_action_name),
                            "Grant Park is Chicago's front yard. (2hrs)", 70.00));
        }
        return catalog;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    // remove product from cart
    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    // Return current cart list
    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }
        return cartList;
    }

}
package com.lee.zoey.travelmate;

import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by user1 on 2017-07-23.
 */

public class ShoppingCartSubItems {
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalogdetails;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalogdetails == null) {
            catalogdetails = new Vector<Product>();
            catalogdetails.add(new Product("PSU Tour", res.getDrawable(R.drawable.ic_action_name),
                    "2hrs", 10.00));
            catalogdetails.add(new Product("Bike Tour", res.getDrawable(R.drawable.ic_action_name),
                    "PSU tour (1hr) + Downtown Tour (3hrs) ", 30.00));
            catalogdetails.add(new Product("Mt. Hood Tour", res.getDrawable(R.drawable.ic_action_name),
                    "PSU tour (1hr) + Downtown Tour (3hrs) ", 30.00));
        }

        return catalogdetails;
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

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }

}

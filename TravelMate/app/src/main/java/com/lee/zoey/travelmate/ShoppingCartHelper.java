package com.lee.zoey.travelmate;

/**
 * Created by user1 on 2017-07-11.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;

import static android.R.attr.checked;

public class ShoppingCartHelper {
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
    private static List<Product> catalog;

    public static List<Product> getCity(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Portland", res.getDrawable(R.drawable.ic_action_name), "", 0));
            catalog.add(new Product("New York", res.getDrawable(R.drawable.ic_action_name), "", 0));
            catalog.add(new Product("LasVegas", res.getDrawable(R.drawable.ic_action_name), "", 0));
        }

        return catalog;
    }
}
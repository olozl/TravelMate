package com.lee.zoey.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user1 on 2017-07-23.
 */

public class CityActivity extends Activity{
    private List<Product> mProductList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        // Obtain a reference to the product catalog
        mProductList = new ArrayList<Product>();
        ArrayAdapter<Product> adapter;
        Spinner TextView01 = (Spinner) findViewById(R.id.CityList);
        for(Product entry:ShoppingCartHelper.getCity(getResources()).keySet()) {
            if (!mProductList.contains(entry))
                mProductList.add(entry);
        }
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_spinner_item, mProductList);
        TextView01.setAdapter(adapter);
        Collections.sort(mProductList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.title.compareToIgnoreCase(o2.title);
            }
        });
        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListCatalog);
        listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),CatalogActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, mProductList.get(position).getTitle());
                startActivity(productDetailsIntent);
            }
        });

        ////////////////////////
        Button addPlan = (Button) findViewById(R.id.ButtonAddCity);
        addPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent addPlanIntent = new Intent(getBaseContext(), WritingFormActivity.class);
                startActivity(addPlanIntent);
            }
        });
        ///////////////////////

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

    }

}

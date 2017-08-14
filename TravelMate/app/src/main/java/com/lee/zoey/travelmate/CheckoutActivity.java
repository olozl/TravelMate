package com.lee.zoey.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class CheckoutActivity extends Activity{
    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetails);

        mCartList = ShoppingCartHelper.getCartList();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListView);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent feedbackIntent = new Intent(getBaseContext(),FeedbackActivity.class);
                feedbackIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, mCartList.get(position).getTitle());
                startActivity(feedbackIntent);
            }
        });

        // Button to go back to city list to add more items
        Button viewCityCart = (Button) findViewById(R.id.backToMain);
        viewCityCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), CityActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });
    }
}

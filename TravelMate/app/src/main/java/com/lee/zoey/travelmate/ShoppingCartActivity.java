package com.lee.zoey.travelmate;


/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ShoppingCartActivity extends Activity {
    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);


        mCartList = ShoppingCartHelper.getCartList();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }


        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
                
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, mCartList.get(position).getTitle());
                startActivity(productDetailsIntent);
            }
        });

        // Button to go back to city list to add more items
        Button viewCityCart = (Button) findViewById(R.id.ListCatalog);
        viewCityCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), CityActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });
        // Button to check out items in cart
        Button checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShoppingCartActivity.this, "Successfully checked out!",
                        Toast.LENGTH_SHORT).show();
                Intent checkoutIntent = new Intent(getBaseContext(), CheckoutActivity.class);
                startActivity(checkoutIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if(mProductAdapter != null) {
            mProductAdapter.notifyDataSetChanged();
        }

        double subTotal = 0;
        for(Product p : mCartList) {
            int quantity = ShoppingCartHelper.getProductQuantity(p);
            double discount = p.price - (p.price * (0.1 * (quantity-1)));
            subTotal += (discount)*quantity;
        }

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText("Subtotal: $" + subTotal);
    }

}
package com.lee.zoey.travelmate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CatalogActivity extends Activity {
    private List<Product> mProductList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogdetails);

        int productIndex = getIntent().getExtras().getInt(
                ShoppingCartSubItems.PRODUCT_INDEX);
        String title = "";
        if(productIndex==0) title = "Portland";
        else if(productIndex==1) title = "New York";
        else if(productIndex==2) title = "LasVegas";
        else if(productIndex==3) title = "Chicago";

        // Obtain a reference to the product catalog
        mProductList = new ArrayList<Product>();
        for(Product val:ShoppingCartHelper.getCity(getResources()).keySet()) {
            if (val.title.equals(title)) {
                    mProductList.add(ShoppingCartHelper.getCity(getResources()).get(val));
            }
        }


        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartSubItems.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        Button viewCityCart = (Button) findViewById(R.id.ListCatalog);
        viewCityCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), CityActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

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
package com.lee.zoey.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class WritingFormActivity extends Activity {
    private String chosenCIty;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writeform);

        final Spinner mCityList = (Spinner) findViewById(R.id.CityList);
        final EditText mProductTitle = (EditText) findViewById(R.id.TextViewProductTitle);
        final EditText mProductDescrip = (EditText) findViewById(R.id.TextViewProductDetails);
        final EditText mProductPrice = (EditText) findViewById(R.id.editPrice);
        final float price = Float.parseFloat(mProductPrice.getText().toString());

        mCityList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosenCIty = mCityList.getSelectedItem().toString();
                chosenCIty = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        // Button to see updated list of tour plans
        Button viewUpdated = (Button) findViewById(R.id.ButtonUpload);
        viewUpdated.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Give an error message if title is not entered
                if(mProductTitle.getText().toString().isEmpty()){
                    mProductTitle.setError("Title not entered");
                    mProductTitle.requestFocus();
                }
                // Give an error message if description is not entered
                if(mProductDescrip.getText().toString().isEmpty()){
                    mProductDescrip.setError("Description not entered");
                    mProductDescrip.requestFocus();
                }
                // Give an error message if price is not entered
                if(mProductPrice.getText().toString().isEmpty()){
                    mProductPrice.setError("Price not entered");
                    mProductPrice.requestFocus();
                }
                // Update list of plans
                if(mProductDescrip.getError()==null && mProductPrice.getError()==null
                        && mProductTitle.getError()==null) {
                    Intent viewListIntent = new Intent(getBaseContext(), CityActivity.class);
                    ShoppingCartHelper.setCity(getResources(), chosenCIty, mProductTitle.getText().toString(),
                            mProductDescrip.getText().toString(), price);
                    startActivity(viewListIntent);
                }
            }
        });
    }
}

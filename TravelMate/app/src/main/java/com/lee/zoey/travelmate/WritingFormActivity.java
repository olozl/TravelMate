package com.lee.zoey.travelmate;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class WritingFormActivity extends Activity {
    private String chosenCIty;
    private double price;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writeform);

        final Spinner mCityList = (Spinner) findViewById(R.id.CityList);
        final EditText mProductTitle = (EditText) findViewById(R.id.TextViewProductTitle);
        final EditText mProductDescrip = (EditText) findViewById(R.id.TextViewProductDetails);
        final EditText mProductPrice = (EditText) findViewById(R.id.editPrice);
        final Calendar calendar = Calendar.getInstance();
        final EditText mProductSchedule = (EditText) findViewById(R.id.scheduleDate);

        // Read chosen city from spinner
        mCityList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosenCIty = mCityList.getSelectedItem().toString();
                chosenCIty = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Select date for traveling
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String format = "MM/dd/yy";
                SimpleDateFormat simpleFormat = new SimpleDateFormat(format, Locale.US);
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                mProductSchedule.setText(simpleFormat.format(calendar.getTime()));
            }
        };

        mProductSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(WritingFormActivity.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
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
                } else {
                    price = Double.parseDouble(mProductPrice.getText().toString());
                }
                // Update list of plans
                if(mProductDescrip.getError()==null && mProductPrice.getError()==null
                        && mProductTitle.getError()==null) {
                    Intent viewListIntent = new Intent(getBaseContext(), CityActivity.class);
                    ShoppingCartHelper.setCity(getResources(), chosenCIty, mProductTitle.getText().toString(),
                            mProductDescrip.getText().toString(), price, LoginActivity.username);
                    startActivity(viewListIntent);
                }
            }
        });
    }
}

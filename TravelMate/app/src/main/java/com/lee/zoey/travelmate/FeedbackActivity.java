package com.lee.zoey.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class FeedbackActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        String productIndex = getIntent().getExtras().getString(
                ShoppingCartHelper.PRODUCT_INDEX);
        Product selected = ShoppingCartHelper.getCity(getResources()).get("");

        for(Product entry : ShoppingCartHelper.getCity(getResources()).values()){
            if(entry.getTitle().equals(productIndex)) {
                selected = entry;
                break;
            }
        }
        final Product selectedProduct = selected;

        // Set the proper image and text
        TextView productTitleTextView = (TextView) findViewById(R.id.PlanTitle);
        productTitleTextView.setText(selectedProduct.title);
        ImageView productImageView = (ImageView) findViewById(R.id.ImageView);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView writerName = (TextView) findViewById(R.id.TravleMateName);
        writerName.setText(selectedProduct.writer);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rateTravelmate);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ///////////
            }
        });
//        EditText commentReview = (EditText) findViewById(R.id.comment);
//        if(commentReview.getText().toString().isEmpty()){
//            commentReview.setError("Please leave a comment!");
//            commentReview.requestFocus();
//        }

        // Button to add travel plans into cart
        Button submitFeedback = (Button) findViewById(R.id.SubmitFeedback);
        submitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Successfully submited feedback!",
                        Toast.LENGTH_SHORT).show();
                Intent feedbackIntent = new Intent(getBaseContext(), CheckoutActivity.class);
                startActivity(feedbackIntent);
            }
        });

    }
}
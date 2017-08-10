package com.lee.zoey.travelmate;
//
//import android.app.Activity;
//import android.os.Bundle;
//

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class WritingFormActivity extends Activity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writeform);

        // Button to see updated list of tour plans
        Button viewUpdated = (Button) findViewById(R.id.ButtonUpload);
        viewUpdated.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewListIntent = new Intent(getBaseContext(), CatalogActivity.class);
                startActivity(viewListIntent);
            }
        });
    }
}

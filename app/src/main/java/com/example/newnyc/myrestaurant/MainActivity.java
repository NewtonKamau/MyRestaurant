package com.example.newnyc.myrestaurant;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findRestaurantButton) Button mfindRestaurantButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mappNameTextView;


    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface Pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mappNameTextView.setTypeface(Pacifico);
        mfindRestaurantButton.setOnClickListener(new View.OnClickListener() {
        @Override
            public  void onClick(View v) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
            intent.putExtra("location", location);
                startActivity(intent);
        }

        });

    }
}

package com.example.newnyc.myrestaurant;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public Button mfindMyRestaurantButton;
    private EditText mLocationEditText;
    private  TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = (EditText) findViewById(R.id.locationEdittext);
        mfindMyRestaurantButton = (Button) findViewById(R.id.findRestaurantButton);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface pacificFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mAppNameTextView.setTypeface(pacificFont);
        mfindMyRestaurantButton.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });

    }
}

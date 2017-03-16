package com.example.newnyc.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.newnyc.myrestaurant.R.layout.activity_restaurant;


public class RestaurantActivity extends AppCompatActivity {
//    public static final String TAG = RestaurantActivity.class.getSimpleName();

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

        private String[] restaurant = new String[] {"Mi Mero Mole", "Mother's Bistro",
                "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
                "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
                "Lardo", "Portland City Grill", "Fat Head's Brewery",
                "Chipotle", "Subway"};

        private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs",
                "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food",
                "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar",
                "Breakfast", "Mexican" };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(activity_restaurant);
            ButterKnife.bind(this);

            MyRestaurantArrayAdapter adapter = new MyRestaurantArrayAdapter(this, android.R.layout.simple_list_item_1, restaurant, cuisines);
            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String restaurant = ((TextView)view).getText().toString();
                    Toast.makeText(RestaurantActivity.this, restaurant, Toast.LENGTH_LONG).show();

                }
            });

            Intent intent = getIntent();
            String location = intent.getStringExtra("location");
            mLocationTextView.setText("Here are all the restaurants near: " + location);

        }
    }

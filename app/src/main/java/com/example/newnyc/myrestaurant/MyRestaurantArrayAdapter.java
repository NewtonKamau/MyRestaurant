package com.example.newnyc.myrestaurant;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by newnyc on 3/16/17.
 */

public class MyRestaurantArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurant;
    private  String[] mCuisines;

    public MyRestaurantArrayAdapter(Context mContext, int resource, String[] mRestaurant, String[] mCuisines) {
        super (mContext, resource);
        this.mContext = mContext;
        this.mRestaurant = mRestaurant;
        this.mCuisines = mCuisines;
    }
    @Override
    public  Object getItem(int position) {
        String restaurant = mRestaurant[position];
        String cuisine = mCuisines[position];
        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }
    @Override
    public int getCount() {
        return mRestaurant.length;
    }
}

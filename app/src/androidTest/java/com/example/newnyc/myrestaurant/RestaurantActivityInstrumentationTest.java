package com.example.newnyc.myrestaurant;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;
/**
 * Created by newnyc on 3/15/17.
 */

public class RestaurantActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<RestaurantActivity> activityActivityTestRule = new ActivityTestRule<>(RestaurantActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        View activityDecorView = activityActivityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "Mi Mero Mole";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
        .atPosition(0)
        .perform(click());
      onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
        .check(matches(withText(restaurantName)));

    }


}

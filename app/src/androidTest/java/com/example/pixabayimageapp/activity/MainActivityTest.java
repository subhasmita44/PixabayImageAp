package com.example.pixabayimageapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import com.example.pixabayimageapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
@Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule=new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void recycler(){
        onView(withId(R.id.rvPhoto)).check(matches(not(isDisplayed())));
         RecyclerView recyclerView=activityActivityTestRule.getActivity().findViewById(R.id.rvPhoto);
         int itemCount=recyclerView.getAdapter().getItemCount();
         Espresso.onView(withId(R.id.rvPhoto)).perform(RecyclerViewActions.actionOnItemAtPosition(3,click()));
    }
}
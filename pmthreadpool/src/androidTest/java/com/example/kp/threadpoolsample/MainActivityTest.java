package com.example.kp.threadpoolsample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by KP on 10/11/2017.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void isCurrentActivityGet(){
        Context appActivity = rule.getActivity();

        assertEquals("MainActivity", appActivity.getClass().getSimpleName());
    }
}
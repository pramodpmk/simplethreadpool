package com.example.kp.threadpoolsample.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import com.example.kp.threadpoolsample.BackButtonListener;

/**
 * Created by KP on 10/10/2017.
 */

public class LockEditText extends EditText {
    /* Must use this constructor in order for the layout files to instantiate the class properly */
    BackButtonListener mListener;
    public LockEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onKeyPreIme (int keyCode, KeyEvent event)
    {
        // Return true if I handle the event:
        // In my case i want the keyboard to not be dismissible so i simply return true
        // Other people might want to handle the event differently
        System.out.println("onKeyPreIme " +event);
        mListener.onBackButton();
        return true;
    }

    public void setBackListener(BackButtonListener newListener) {
        mListener = newListener;
    }
}

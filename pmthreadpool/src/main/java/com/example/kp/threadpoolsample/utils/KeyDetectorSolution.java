package com.example.kp.threadpoolsample.utils;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by KP on 10/10/2017.
 */

public class KeyDetectorSolution extends android.support.v7.widget.AppCompatEditText {
    public KeyDetectorSolution(Context context) {
        super(context);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Log.d("KEy PRESSED", "" + keyCode + " " + event.getClass().getSimpleName());
        return super.onKeyPreIme(keyCode, event);
    }
}

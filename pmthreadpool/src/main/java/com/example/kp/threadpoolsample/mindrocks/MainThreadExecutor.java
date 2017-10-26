package com.example.kp.threadpoolsample.mindrocks;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * Created by KP on 10/10/2017.
 */

public class MainThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}

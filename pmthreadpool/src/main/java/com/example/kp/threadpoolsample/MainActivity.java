package com.example.kp.threadpoolsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kp.threadpoolsample.mindrocks.DefaultExecutorSupplier;
import com.example.kp.threadpoolsample.mindrocks.Priority;
import com.example.kp.threadpoolsample.mindrocks.PriorityRunnable;
import com.example.kp.threadpoolsample.utils.LockEditText;

import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity{

    Future future;

    LockEditText mEditText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        doSomeBackgroundWork();
        doSomeUIWork();
        doProperBackgroundTask();
        doSomeTaskAtHighPriority();
    }

    private void initViews() {
        mEditText = (LockEditText) findViewById(R.id.editTextNew);
        mButton = (Button) findViewById(R.id.buttonNew);
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        mEditText.setBackListener(newListener);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void doSomeBackgroundWork(){
        DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do some background work here.
                        Log.d("THREAD POOL TASK", "EXECUTE");
                    }
                });
    }

    public void doSomeUIWork(){
        DefaultExecutorSupplier.getInstance().forMainThreadTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do someUI work here.
                        Log.d("THREAD POOL TASK", "EXECUTE");
                        Toast.makeText(MainActivity.this, "NOTIFY", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void doProperBackgroundTask(){
        future = DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                .submit(new Runnable() {
                    @Override
                    public void run() {
                        // do some background work here.
                    }
                });
    }

    /*
* do some task at high priority
*/
    public void doSomeTaskAtHighPriority(){
        future = DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                .submit(new PriorityRunnable(Priority.HIGH) {
                    @Override
                    public void run() {
                        // do some background work here at high priority.
                        Log.d("PRIORITY HIGH", "TASK");
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (future != null)
            future.cancel(true);
    }

    BackButtonListener newListener = new BackButtonListener() {
        @Override
        public void onBackButton() {
            Toast.makeText(MainActivity.this, "BACK", Toast.LENGTH_SHORT).show();
        }
    };

    public Activity getCurrentActivity(){
        return this;
    }
}

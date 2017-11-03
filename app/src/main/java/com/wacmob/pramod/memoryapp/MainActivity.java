package com.wacmob.pramod.memoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kp.threadpoolsample.mindrocks.ScheduleThreadPoolSupplier;

import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    Future future;
    Button mButtonTry, mButtonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonTry = (Button) findViewById(R.id.buttonTry);
        mButtonStop = (Button) findViewById(R.id.buttonStop);
        mButtonTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                future = DefaultExecutorSupplier.getInstance().forBackgroundTasks().submit(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
                ScheduleThreadPoolSupplier.getInstance().runDelayTask(new Runnable() {
                    @Override
                    public void run() {

                        Log.d("SCHEDULED", "TASK");
                    }
                }, 5, 5);
                //ScheduleUtils.getInstance().runDelayService(getApplicationContext());
            }
        });
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleThreadPoolSupplier.getInstance().stopDelayTask();
                //ScheduleUtils.getInstance().stopDelayService(getApplicationContext());

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (future != null)
            future.cancel(true);
    }

//    public class NewService extends Service{
//        @Nullable
//        @Override
//        public IBinder onBind(Intent intent) {
//            return null;
//        }
//
//        public NewService(){
//
//        }
//
//        @Override
//        public void onCreate() {
//            super.onCreate();
//            Log.d("SERVICE", "STARTED");
//            ScheduleUtils.getInstance().runDelayService();
//        }
//
//        @Override
//        public int onStartCommand(Intent intent, int flags, int startId) {
//            ScheduleUtils.getInstance().runDelayService();
//            return super.onStartCommand(intent, flags, startId);
//        }
//
//        @Override
//        public void onDestroy() {
//            super.onDestroy();
//        }
//    }
}

package com.example.kp.threadpoolsample.mindrocks;

import android.content.Context;
import android.content.Intent;
import android.os.Process;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by KP on 11/3/2017.
 */

public class ScheduleThreadPoolSupplier {
    final static DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);
    private static ScheduledFuture<?> mScheduledFuture;
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static ScheduleThreadPoolSupplier sInstance;

    // Create a scheduled thread pool with 5 core threads
    ScheduledThreadPoolExecutor sch;
    ScheduledExecutorService scheduledExecutorService;

//    Runnable delayTask = new Runnable(){
//        @Override
//        public void run() {
//            try{
//                System.out.println("\t delayTask Execution Time: "
//                        + fmt.format(new Date()));
//                Thread.sleep(5 * 1000);
//            }catch(Exception e){
//
//            }
//        }
//    };

    public static ScheduleThreadPoolSupplier getInstance(){
        if (sInstance == null) {
            synchronized (ScheduleThreadPoolSupplier.class) {
                sInstance = new ScheduleThreadPoolSupplier();
            }
        }
        return sInstance;
    }


    private ScheduleThreadPoolSupplier(){
        ThreadFactory backgroundPriorityThreadFactory = new
                PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);
        sch = (ScheduledThreadPoolExecutor)
                Executors.newScheduledThreadPool(NUMBER_OF_CORES * 2, backgroundPriorityThreadFactory);
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void runDelayTask(Runnable delayTask, int initDelay, int period){

        mScheduledFuture = sch.scheduleAtFixedRate(delayTask, initDelay, period, TimeUnit.SECONDS);
        return;
    }


    public void stopDelayTask(){
        if (mScheduledFuture != null)
            mScheduledFuture.cancel(false);
    }

}


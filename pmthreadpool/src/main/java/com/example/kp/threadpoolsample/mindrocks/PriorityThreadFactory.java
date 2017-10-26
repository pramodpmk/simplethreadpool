package com.example.kp.threadpoolsample.mindrocks;

import android.os.Process;

import java.util.concurrent.ThreadFactory;

/**
 * Created by KP on 10/10/2017.
 */

public class PriorityThreadFactory implements ThreadFactory{

        private final int mThreadPriority;

        public PriorityThreadFactory(int threadPriority) {
            mThreadPriority = threadPriority;
        }

        @Override
        public Thread newThread(final Runnable runnable) {
            Runnable wrapperRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Process.setThreadPriority(mThreadPriority);

                    } catch (Throwable t) {

                    }
                    runnable.run();
                }
            };
            return new Thread(wrapperRunnable);
        }

}

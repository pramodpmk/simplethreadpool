package com.example.kp.threadpoolsample.mindrocks;

/**
 * Created by KP on 10/10/2017.
 */

public class PriorityRunnable implements Runnable {

    private final Priority priority;

    public PriorityRunnable(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        // nothing to do here.
    }

    public Priority getPriority() {
        return priority;
    }

}

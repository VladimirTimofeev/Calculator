package worker.impl;

import worker.OnTaskDoneListener;

public class Worker implements OnTaskDoneListener {

    public void onDone(String result) {
        };
    private OnTaskDoneListener callback;


    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100 ; i++) {
            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}

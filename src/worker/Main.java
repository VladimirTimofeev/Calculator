package worker;

import worker.impl.Error;
import worker.impl.Worker;

public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;

        Worker warker = new Worker(listener);
        Error error = new Error(errorListener);
        warker.start();
        error.start();
    }
}

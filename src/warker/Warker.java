package warker;

public class Warker {
    @FunctionalInterface
    public interface OnTaskDoneListener{
        void onDone(String result);
    }
    private OnTaskDoneListener callback;

    public Warker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String result);
    }
    private OnTaskErrorListener errorCallback;

    public Warker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }


    public void start() {
        for (int i = 0; i < 100 ; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}

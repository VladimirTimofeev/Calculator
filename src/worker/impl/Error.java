package worker.impl;
import worker.OnTaskErrorListener;
public class Error implements OnTaskErrorListener {
    public void onError(String result) {
        };
    private OnTaskErrorListener errorCallback;

    public Error(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100 ; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " error");
            }
        }
    }
}
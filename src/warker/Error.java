package warker;
public class Error {
    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String result);
    }
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
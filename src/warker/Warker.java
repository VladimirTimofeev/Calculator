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

    public void start() {
        for (int i = 0; i < 100 ; i++) {
            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}

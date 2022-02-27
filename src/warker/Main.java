package warker;

public class Main {
    public static void main(String[] args) {
        Warker.OnTaskDoneListener listener = System.out::println;
        Error.OnTaskErrorListener errorListener = System.out::println;

        Warker warker = new Warker(listener);
        Error error = new Error(errorListener);
        warker.start();
        error.start();
    }
}

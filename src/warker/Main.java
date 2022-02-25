package warker;

public class Main {
    public static void main(String[] args) {
        Warker.OnTaskDoneListener listener = System.out::println;
        Warker.OnTaskErrorListener errorListener = System.out::println;

        Warker warker = new Warker(listener, errorListener);
        warker.start();
    }
}

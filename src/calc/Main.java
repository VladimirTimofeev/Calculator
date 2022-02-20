package calc;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(2, 3);
        int b = calculator.minus.apply(8, 5);
        int c = calculator.multiply.apply(6, 5);

        calculator.println.accept(a);
        calculator.println.accept(b);
        calculator.println.accept(c);

    }
}
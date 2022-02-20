package calc;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(2, 3);
        int b = calculator.minus.apply(1, 1);
        int c = calculator.multiply.apply(6, 5);
        int e = calculator.devide.apply(5, 2);

        int d = calculator.abs.apply(-4);

        calculator.println.accept(a);
        calculator.println.accept(b);
        calculator.println.accept(c);
        calculator.println.accept(d);
        calculator.println.accept(e);
        System.out.println(calculator.isPositive.test(5));

    }
}
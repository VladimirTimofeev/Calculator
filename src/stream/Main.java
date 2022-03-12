package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.List.of;

public class Main {
    public static void main(String[] args) {
        List<Integer> intlist = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intlistplus = new java.util.ArrayList<>(of());

        for (int y : intlist) {
            if (y > 0) {
                if (y % 2 == 0) {
                    intlistplus.add(y);
                }
            }
        }
        Collections.sort(intlistplus);
        System.out.println(intlistplus);
    }
}

package methods.more_exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Currying
        int result1 = sumElementsFunction
                .apply(1)
                .apply(2)
                .apply(3);

        System.out.println("Currying...");
        System.out.println(result1);

        //Partial application
        Function<Integer, Function<Integer, Integer>> partial1 = sumElementsFunction.apply(1);

        Function<Integer, Integer> partial2 = partial1.apply(2);

        int result2 = partial2.apply(3);

        System.out.println("Partial Application...");
        System.out.println(result2);
    }

    private static final Function<Integer, Function<Integer, Function<Integer, Integer>>> sumElementsFunction =
            (a) -> (b) -> (c) -> sumElements(a, b, c);

    private static Integer sumElements(int a, int b, int c) {
        return a + b + c;
    }
}



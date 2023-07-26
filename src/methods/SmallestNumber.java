package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class SmallestNumber {
    public static void main(String[] args) throws IOException {
//        Thread one = new Thread(() -> {
//            int counter = 0;
//
//            while (true) {
//                if (counter > 20) {
//                    break;
//                }
//                System.out.println("Thread one! " + counter++);
//            }
//        });
//
//        Thread two = new Thread(() -> {
//            int counter = 0;
//
//            while (true) {
//                if (counter > 20) {
//                    break;
//                }
//                System.out.println("Thread two! " + counter++);
//            }
//
//        });
//
//        System.out.println("Maint");
//
//        two.start();
//        System.out.println("Maint");
//
//        one.start();
//        System.out.println("Maint");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int one = Integer.parseInt(reader.readLine());
        int two = Integer.parseInt(reader.readLine());
        int three = Integer.parseInt(reader.readLine());

        System.out.println(getMin(one, two, three));
    }

    //    private static int getMin(int one, int two, int three) {
//        return Math.min(one, Math.min(two, three));
//    }
    private static int getMin(int... numbers) throws NoSuchElementException {
        return Arrays.stream(numbers).min().orElse(Integer.MIN_VALUE);
    }
}
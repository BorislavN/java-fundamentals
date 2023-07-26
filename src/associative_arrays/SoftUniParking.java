package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> parkingLot = new LinkedHashMap<>();
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            switch (data[0]) {
                case "register":
                    if (parkingLot.containsKey(data[1])) {
                        System.out.printf("ERROR: already registered with plate number %s%n"
                                , parkingLot.get(data[1]));

                        continue;
                    }
                    parkingLot.put(data[1], data[2]);

                    System.out.printf("%s registered %s successfully%n"
                            , data[1]
                            , data[2]);

                    break;
                case "unregister":
                    if (!parkingLot.containsKey(data[1])) {
                        System.out.printf("ERROR: user %s not found%n", data[1]);
                        continue;
                    }

                    parkingLot.remove(data[1]);

                    System.out.printf("%s unregistered successfully%n"
                            , data[1]);

                    break;

            }
        }

        parkingLot.forEach((key, val) -> System.out.printf("%s => %s%n", key, val));
    }
}
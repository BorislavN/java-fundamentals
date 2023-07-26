package objects_and_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class AdvertisementMessages {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Advertisement advertisement = new Advertisement();
        int messages = Integer.parseInt(reader.readLine());


        while (messages-- > 0) {
            System.out.println(advertisement.getRandomMessage());
        }
    }

    private static class Advertisement {
        private final Random random;

        private final String[] phrases;

        private final String[] events;

        private final String[] authors;

        private final String[] cities;

        private Advertisement() {
            this.phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product."
                    , "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

            this.events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Try it yourself, I am very satisfied."
                    , "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "I feel great!"};

            this.authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

            this.cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

            this.random = new Random();
        }

        private String getRandomMessage() {
            return String.format("%s %s %s - %s"
                    , this.phrases[this.random.nextInt(phrases.length)]
                    , this.events[this.random.nextInt(events.length)]
                    , this.authors[this.random.nextInt(authors.length)]
                    , this.cities[this.random.nextInt(cities.length)]);
        }
    }
}
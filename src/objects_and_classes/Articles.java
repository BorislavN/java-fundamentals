package objects_and_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Articles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(",\\s+");
        int inputs = Integer.parseInt(reader.readLine());

        Article article = new Article(data[0], data[1], data[2]);

        while (inputs-- > 0) {
            String[] arguments = reader.readLine().split(": ");

            switch (arguments[0]) {
                case "Edit" -> article.edit(arguments[1]);
                case "ChangeAuthor" -> article.changeAuthor(arguments[1]);
                case "Rename" -> article.rename(arguments[1]);
            }
        }
        System.out.println(article);
    }

    private static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        public void edit(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public void rename(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}
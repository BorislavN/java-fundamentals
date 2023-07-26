package text_processing.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String title = reader.readLine();
        String article = reader.readLine();
        String comment;

        StringBuilder output = new StringBuilder();
        output.append(getTag("h1",title));
        output.append(getTag("article",article));

        while (!"end of comments".equals(comment = reader.readLine())) {
            output.append(getTag("div",comment));
        }

        System.out.println(output);
    }

    private static String getTag(String tag, String content) {
        return String.format("<%s>%n\t%s%n</%s>%n", tag, content, tag);
    }
}
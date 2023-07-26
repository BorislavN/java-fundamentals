package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnowBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int balls = Integer.parseInt(reader.readLine());
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        double bestScore = 0;

        while (balls-- > 0) {
            int snow = Integer.parseInt(reader.readLine());
            int time = Integer.parseInt(reader.readLine());
            int quality = Integer.parseInt(reader.readLine());

            double score =  Math.pow(snow*1.0 / time, quality);

            if (score > bestScore) {
                bestScore = score;
                bestSnow = snow;
                bestTime = time;
                bestQuality = quality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)%n",bestSnow,bestTime,bestScore,bestQuality);
    }
}
package de.katta.bowlinggame;

public class BowlingGame {
    private int[] points = new int[21];
    private int current;

    public void roll(int i) {
        points[current++] = i;
    }

    public int score() {
        int result = 0;
        for (int i = 0; i < 20; i += 2) {
            int sum = points[i] + points[i + 1];
            // strike
            if (points[i] == 10) {
                result += sum + points[i + 2] + points[i + 3];
            // spare
            } else if (sum == 10) {
                result += sum + points[i + 2];
            } else {
                result += sum;
            }

            if (i == 18) {
                result += points[20];
            }
        }
        return result;
    }
}

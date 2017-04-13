package de.katta.bowlinggame;

public class BowlingFrame {
    private int[] pins = new int[2];
    private int current;

    public void roll(int i) {
        pins[current++] = i;
    }

    public int score() {
        return pins[0] + pins[1];
    }

    public boolean isSpare() {
        return pins[0] + pins[1] == 10;
    }

    public boolean complete() {
        return current > 1 || isStrike();
    }

    public boolean isStrike() {
        return pins[0] == 10;
    }
}

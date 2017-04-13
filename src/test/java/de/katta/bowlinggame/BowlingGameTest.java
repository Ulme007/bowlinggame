package de.katta.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void testWorstGame() throws Exception {
        // when
        rollCompleteGame(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});

        // then
        assertEquals(0, game.score());
    }

    @Test
    public void testRollEveryTimeOne() throws Exception {
        // when
        rollCompleteGame(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});

        // then
        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() throws Exception {
        // when
        rollCompleteGame(new int[]{6,4,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});

        // then
        assertEquals(12, game.score());
    }

    @Test
    public void testOneSpareAtTheEnd() throws Exception {
        // when
        rollCompleteGame(new int[]{
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,6,4,1});

        // then
        assertEquals(12, game.score());
    }

    //@Test
    public void testOneStrikeNotAtTheEnd() throws Exception {
        // when
        rollCompleteGame(new int[]{
                10,1,1,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,0});

        // then
        assertEquals(14, game.score());
    }

    private void rollCompleteGame(int[] rolls) {
        for (int i = 0; i < rolls.length; i++) {
            game.roll(rolls[i]);
        }
    }
}

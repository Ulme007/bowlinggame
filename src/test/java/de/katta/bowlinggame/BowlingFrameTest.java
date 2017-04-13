package de.katta.bowlinggame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BowlingFrameTest {

    private BowlingFrame bowlingFrame;

    @Before
    public void setUp() throws Exception {
        bowlingFrame = new BowlingFrame();
    }

    @Test
    public void testFrameWithOnePin() throws Exception {
        // when
        bowlingFrame.roll(1);

        // then
        assertEquals(1, bowlingFrame.score());
    }

    @Test
    public void testFrameComplete() throws Exception {
        // when
        bowlingFrame.roll(1);
        bowlingFrame.roll(2);

        // then
        assertTrue(bowlingFrame.complete());
    }

    @Test
    public void testFrameIsSpare() throws Exception {
        // when
        bowlingFrame.roll(1);
        bowlingFrame.roll(9);

        // then
        assertTrue(bowlingFrame.isSpare());
    }

    @Test
    public void testFrameNotComplete() throws Exception {
        // when
        bowlingFrame.roll(1);

        // then
        assertFalse(bowlingFrame.complete());
    }

    @Test
    public void testFrameNoRollsIsNotComplete() throws Exception {
        // when

        // then
        assertFalse(bowlingFrame.complete());
    }


    @Test
    public void testIsCompleteAfterStrike() throws Exception {
        // when
        bowlingFrame.roll(10);

        // then
        assertTrue(bowlingFrame.complete());
    }

    @Test
    public void testIsStrike() throws Exception {
        // when
        bowlingFrame.roll(10);

        // then
        assertTrue(bowlingFrame.isStrike());
    }


}

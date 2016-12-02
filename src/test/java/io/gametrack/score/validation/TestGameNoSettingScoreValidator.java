package io.gametrack.score.validation;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Kevin Sutton
 */
public class TestGameNoSettingScoreValidator {

    private ScoreValidator validator;

    @Before
    public void setUp() {
        this.validator = new GameNoSettingScoreValidator();
    }

    @Test
    public void testValidScores() {
        assertTrue(validator.isValidScore(0, 0));
        assertTrue(validator.isValidScore(20, 0));
        assertTrue(validator.isValidScore(20, 20));
        assertTrue(validator.isValidScore(21, 20));
        assertTrue(validator.isValidScore(20, 21));
    }

    @Test
    public void testInvalidScores() {
        assertFalse(validator.isValidScore(20, 22));
        assertFalse(validator.isValidScore(30, 0));
    }

    @Test
    public void testNegativeScores() {
        assertTrue(validator.isValidScore(-4, 0));
        assertTrue(validator.isValidScore(10, -8));
    }


    @Test
    public void testValidResult() {
        assertTrue(validator.isValidResult(20, 21));
        assertTrue(validator.isValidResult(21, 0));
    }

    @Test
    public void testInvalidResult() {
        assertFalse(validator.isValidResult(-4, 0));
        assertFalse(validator.isValidResult(10, -8));
        assertFalse(validator.isValidResult(22, 12));
        assertFalse(validator.isValidResult(22, 20));
    }

}

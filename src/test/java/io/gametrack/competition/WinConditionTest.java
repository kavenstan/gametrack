package io.gametrack.competition;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kevin on 27/11/2016.
 */
public class WinConditionTest {

    private Game game;
    private WinConditionEvaluator gameSettingEvaluator;

    @Before
    public void setUp() {
        this.game = new Game();
        this.gameSettingEvaluator = new GameSettingWinConditionEvaluator(this.game);
    }

    @Test
    public void testCanNotWinByOne() {
        game.scores = new int[] {20, 21};
        assertFalse(gameSettingEvaluator.isWon());
    }

    @Test
    public void testWinAtThirty() {
        game.scores = new int[] {28, 29};
        assertFalse(gameSettingEvaluator.isWon());
        game.scores = new int[] {29, 29};
        assertFalse(gameSettingEvaluator.isWon());
        game.scores = new int[] {30, 29};
        assertTrue(gameSettingEvaluator.isWon());
    }
}

package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kevin Sutton
 */
public class GameTest extends ContestTest {

    private Game game;

    @Before
    public void setUp() {
        this.contest = new Game(new Match(GameType.MENS_SINGLES));
        super.setUp();
        this.game = (Game) contest;
    }

    @Test
    public void testNoScore() {
        assertEquals(0, game.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, game.getScores().get(SIDE_TWO).getScore());
    }

}

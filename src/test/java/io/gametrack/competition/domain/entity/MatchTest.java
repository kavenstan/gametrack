package io.gametrack.competition.domain.entity;

import io.gametrack.player.Side;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kevin Sutton
 */
public class MatchTest extends ContestTest {

    private Match match;

    @Before
    public void setUp() {
        this.contest = new Match();
        super.setUp();
        this.match = (Match) contest;
    }

    @Test
    public void testNoScores() {
        assertEquals(0, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, match.getScores().get(SIDE_TWO).getScore());
    }

    @Test
    public void testScoreProgression() {
//        match.getGames().add(gameWithWinner(SIDE_ONE));
//        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
//        assertEquals(0, match.getScores().get(SIDE_TWO).getScore());
//
//        match.getGames().add(gameWithWinner(SIDE_TWO));
//        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
//        assertEquals(1, match.getScores().get(SIDE_TWO).getScore());
//
//        match.getGames().add(gameWithWinner(SIDE_TWO));
//        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
//        assertEquals(2, match.getScores().get(SIDE_TWO).getScore());
    }

    private Game gameWithWinner(Side side) {
        Game game = new Game();
        game.setWinner(side);
        return game;
    }


}

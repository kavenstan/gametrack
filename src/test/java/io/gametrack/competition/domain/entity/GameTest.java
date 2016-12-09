package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreSystemType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Kevin Sutton
 */
public class GameTest extends ContestTest {

    private Game game;
    private Match match;

    private GameType gameType = GameType.MENS_SINGLES;

    @Before
    public void setUp() {
        super.setUp();
        this.match = new Match.Builder(this.gameType, ScoreSystemType.MATCH_BEST_OF_THREE_GAMES, this.sides).build();
        this.game = new Game.Builder(this.match, ScoreSystemType.GAME_WITH_SETTING).build();
    }

    @Test
    public void testNoScore() {
        assertEquals(0, game.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, game.getScores().get(SIDE_TWO).getScore());
    }

    @Test
    public void testScoreProgression() {
        game.setScore(SIDE_ONE, 1);
        assertEquals(1, game.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, game.getScores().get(SIDE_TWO).getScore());

        game.setScore(SIDE_TWO, 1);
        assertEquals(1, game.getScores().get(SIDE_ONE).getScore());
        assertEquals(1, game.getScores().get(SIDE_TWO).getScore());

        game.setScore(SIDE_TWO, 2);
        assertEquals(1, game.getScores().get(SIDE_ONE).getScore());
        assertEquals(2, game.getScores().get(SIDE_TWO).getScore());
    }

    @Test
    public void testBuilderFullAttributes() {
        Game game = new Game.Builder(this.match, ScoreSystemType.GAME_WITH_SETTING).build();
        assertEquals(this.gameType, game.getGameType());
        assertEquals(this.match, game.getMatch());
        assertFalse(game.getHomeSide().isPresent());

        this.match.setHomeSide(sideOne);
        assertTrue(game.getHomeSide().isPresent());

        assertEquals(this.sideOne, game.getHomeSide().get());
    }

    @Test
    public void testSides() {
        assertEquals(2, game.getScores().size());
        assertEquals(sideOne, game.getScores().get(SIDE_ONE).getSide());
        assertEquals(sideTwo, game.getScores().get(SIDE_TWO).getSide());
    }


}

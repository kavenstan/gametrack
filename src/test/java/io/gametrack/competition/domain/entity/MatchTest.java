package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.score.ScorePair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Kevin Sutton
 */
public class MatchTest extends ContestTest {

    private Match match;
    private final ScoreSystemType scoreSystemType = ScoreSystemType.MATCH_BEST_OF_THREE_GAMES;
    private final GameType gameType = GameType.MENS_SINGLES;

    @Before
    public void setUp() {
        super.setUp();
        this.match = new Match.Builder(gameType, scoreSystemType, this.sides)
                .build();
    }

    @Test
    public void testNoScores() {
        assertEquals(0, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, match.getScores().get(SIDE_TWO).getScore());
    }

    @Test
    public void testScoreProgression() {
        match.setScore(SIDE_ONE, 1);
        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, match.getScores().get(SIDE_TWO).getScore());

        match.setScore(SIDE_TWO, 1);
        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(1, match.getScores().get(SIDE_TWO).getScore());

        match.setScore(SIDE_TWO, 2);
        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(2, match.getScores().get(SIDE_TWO).getScore());
    }

    @Test
    public void testBuilderFullAttributes() {
        Match match = new Match.Builder(gameType, scoreSystemType, sides).withHomeSide(sideOne).build();
        assertEquals(this.gameType, match.getGameType());
        assertEquals(this.scoreSystemType, match.getScoreSystemType());

        assertTrue(match.getHomeSide().isPresent());
        assertEquals(this.sideOne, match.getHomeSide().get());

    }

    @Test
    public void testSides() {
        assertEquals(2, match.getScores().size());
        assertEquals(sideOne, match.getScores().get(SIDE_ONE).getSide());
        assertEquals(sideTwo, match.getScores().get(SIDE_TWO).getSide());
    }

    @Test
    public void testGames() {
        assertNotNull(match.getGames());
        assertEquals(0, match.getGames().size());
    }

    @Test
    public void testContestWinner() {
        assertFalse(match.getWinner().isPresent());
        match.setWinner(sideOne);
        assertTrue(match.getWinner().isPresent());
        assertEquals(sideOne, match.getWinner().get());
    }

    @Test
    public void testContestScores() {
        assertEquals(0, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(0, match.getScores().get(SIDE_TWO).getScore());
        match.setScores(1, 1);
        assertEquals(1, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(1, match.getScores().get(SIDE_TWO).getScore());

        ScorePair scorePair = new ScorePair(2, 2);
        match.setScores(scorePair);
        assertEquals(2, match.getScores().get(SIDE_ONE).getScore());
        assertEquals(2, match.getScores().get(SIDE_TWO).getScore());

        assertEquals(scorePair, match.getScorePair());
    }

    @Test
    public void testContestState() {
        assertNull(match.getState());
        ContestState state = ContestState.CREATED;
        match.setState(state);
        assertEquals(state, match.getState());
    }
}

package io.gametrack.competition;

import io.gametrack.player.MensSingles;
import io.gametrack.player.Player;
import io.gametrack.player.Side;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Kevin Sutton
 */
public class GameTest {

    private Game game;
    private Side sideOne;
    private Side sideTwo;

    @Before
    public void setUp() {
        this.game = new Game();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        this.sideOne = new MensSingles(playerOne);
        this.sideTwo = new MensSingles(playerTwo);
        this.game.setSides(sideOne, sideTwo);
    }

    @Test
    public void testNoPoints() {
        assertEquals(new int [] {0, 0}, game.scores);
    }

    @Test
    public void testPointProgression() {
        game.incrementScore(sideOne);
        assertArrayEquals(new int [] {1, 0}, game.scores);
        addScoresForSide(20, sideOne);
        assertArrayEquals(new int [] {21, 0}, game.scores);
    }

    @Test
    public void testCanNotWinByOne() {
        addScoresForBoth(20);
        addScoresForSide(1, sideOne);
        assertArrayEquals(new int [] {21, 20}, game.scores);
        assertNotEquals(ContestState.WON, game.getState());
    }

    @Test
    public void testWinAtThirty() {
        addScoresForBoth(29);
        assertArrayEquals(new int [] {29, 29}, game.scores);
        assertNotEquals(ContestState.WON, game.getState());
        addScoresForSide(1, sideOne);
        assertArrayEquals(new int [] {30, 29}, game.scores);
        assertEquals(ContestState.WON, game.getState());
    }

    @Test
    public void testStartGame() {
        assertEquals(ContestState.StateType.NOT_STARTED, game.getState().getStateType());
        assertNull(game.getEndedAt());
        game.start();
        assertEquals(ContestState.StateType.IN_PROGRESS, game.getState().getStateType());
        assertNotNull(game.getStartedAt());
    }

    @Test
    public void testEndGame() {
        assertNull(game.getEndedAt());
        addScoresForSide(10, sideOne);
        game.start();
        assertNull(game.getEndedAt());
        addScoresForSide(11, sideOne);
        assertNotNull(game.getEndedAt());
    }


    private void addScoresForSide(int scoresToAdd, Side side) {
        for (int i = 0; i < scoresToAdd; i++) {
            game.incrementScore(side);
        }
    }

    private void addScoresForBoth(int scoresToAdd) {
        for (int i = 0; i < scoresToAdd; i++) {
            game.incrementScore(sideOne);
            game.incrementScore(sideTwo);
        }
    }

}

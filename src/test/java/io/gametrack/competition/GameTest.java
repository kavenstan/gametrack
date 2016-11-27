package io.gametrack.competition;

import io.gametrack.player.MensSingles;
import io.gametrack.player.Player;
import io.gametrack.player.Side;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
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
    private WinConditionEvaluator mockEvaluator;

    @Before
    public void setUp() {
        this.game = new Game();
        this.mockEvaluator = EasyMock.createMock(WinConditionEvaluator.class);
        this.game.setWinConditionEvaluator(mockEvaluator);

        Player playerOne = new Player();
        Player playerTwo = new Player();
        this.sideOne = new MensSingles(playerOne);
        this.sideTwo = new MensSingles(playerTwo);
        this.game.setSides(sideOne, sideTwo);
    }

    @Test
    public void testNoPoints() {
        assertArrayEquals(new int [] {0, 0}, game.scores);
    }

    @Test
    public void testPointProgression() {
        expect(mockEvaluator.isWon()).andReturn(false).times(2);
        replay(mockEvaluator);

        game.incrementScore(sideOne);
        assertArrayEquals(new int [] {1, 0}, game.scores);
        game.incrementScore(sideTwo);
        assertArrayEquals(new int [] {1, 1}, game.scores);

        verify(mockEvaluator);
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
        game.start();

        expect(mockEvaluator.isWon()).andReturn(false);
        expect(mockEvaluator.isWon()).andReturn(true);
        replay(mockEvaluator);

        game.incrementScore(sideOne);
        assertNull(game.getEndedAt());

        game.incrementScore(sideOne);
        assertNotNull(game.getEndedAt());

        verify(mockEvaluator);
    }

}

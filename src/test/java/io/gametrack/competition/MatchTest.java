package io.gametrack.competition;

import io.gametrack.player.MensSingles;
import io.gametrack.player.Player;
import io.gametrack.player.Side;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kevin Sutton
 */
public class MatchTest {

    private Contest match;
    private Side sideOne;
    private Side sideTwo;

    @Before
    public void setUp() {
        this.match = new Match();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        this.sideOne = new MensSingles(playerOne);
        this.sideTwo = new MensSingles(playerTwo);
        this.match.setSides(sideOne, sideTwo);
    }

    @Test
    public void testNoPoints() {
        assertEquals(new int [] {0, 0}, match.scores);
    }

}

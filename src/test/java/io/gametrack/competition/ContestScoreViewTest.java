package io.gametrack.competition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kevin Sutton
 */
public class ContestScoreViewTest {

    private Contest contest;
    private ContestScoreView view;

    @Before
    public void setUp() {
        this.contest = new Game();
        this.view = new ContestScoreView(contest);
    }

    @Test
    public void testNoScores() {
        contest.scores = new int[] {0, 0};
        assertEquals("0-0", view.score());
    }

    @Test
    public void testWinningScores() {
        contest.scores = new int[] {21, 12};
        assertEquals("21-12", view.score());
    }
}

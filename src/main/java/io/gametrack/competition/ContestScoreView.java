package io.gametrack.competition;

import io.gametrack.player.Side;

/**
 * @author Kevin Sutton
 */
public class ContestScoreView {
    private Contest contest;

    public ContestScoreView(Contest contest) {
        this.contest = contest;
    }

    public String score() {
        final String scoreDivider = "-";
        return contest.scores[0] + scoreDivider + contest.scores[1];
    }

    public String scoreOfSide(Side side) {
        return String.valueOf(contest.sideScoreIndex(side));
    }
}

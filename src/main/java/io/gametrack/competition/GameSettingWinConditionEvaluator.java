package io.gametrack.competition;

/**
 * Created by kevin on 27/11/2016.
 */
public class GameSettingWinConditionEvaluator implements WinConditionEvaluator {
    private final Contest contest;

    public GameSettingWinConditionEvaluator(Game game) {
        this.contest = game;
    }

    @Override
    public boolean isWon() {
        final int minPointsToWin = 21;
        if (contest.scores[0] < minPointsToWin && contest.scores[1] < minPointsToWin) {
            return false;
        }
        final int maxPointsPossible = 30;
        if (contest.scores[0] >= maxPointsPossible || contest.scores[1] >= maxPointsPossible) {
            return true;
        }

        int absoluteDifference = Math.abs(contest.scores[0] - contest.scores[1]);
        return absoluteDifference >= 2;
    }
}

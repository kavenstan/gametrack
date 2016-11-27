package io.gametrack.competition;

/**
 * Created by kevin on 27/11/2016.
 */
public class GameNoSettingWinConditionEvaluator implements WinConditionEvaluator {

    private final Contest contest;

    public GameNoSettingWinConditionEvaluator(Game game) {
        this.contest = game;
    }

    @Override
    public boolean isWon() {
        final int maxPointsPossible = 21;
        return (contest.scores[0] >= maxPointsPossible || contest.scores[1] >= maxPointsPossible);
    }
}

package io.gametrack.score.validation;

/**
 * @author Kevin Sutton
 */
public class GameNoSettingScoreValidator implements ScoreValidator {

    private final int MIN_WIN_SCORE = 21;

    @Override
    public boolean isValidScore(final int scoreOne, final int scoreTwo) {
        if (scoreOne > MIN_WIN_SCORE || scoreTwo > MIN_WIN_SCORE) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidResult(final int scoreOne, final int scoreTwo) {
        return isValidScore(scoreOne, scoreTwo) &&
                (scoreOne == MIN_WIN_SCORE || scoreTwo == MIN_WIN_SCORE) &&
                scoreOne != scoreTwo;
    }

}

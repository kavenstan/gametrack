package io.gametrack.score.validation;

/**
 * @author Kevin Sutton
 */
public class GameSettingScoreValidator implements ScoreValidator {

    private final int MIN_WIN_SCORE = 21;
    private final int MAX_SCORE = 30;
    private final int WIN_MARGIN = 2;

    private int highScore;
    private int absoluteDifference;

    private void calculateValues(final int scoreOne, final int scoreTwo) {
        this.highScore = scoreOne >= scoreTwo ? scoreOne : scoreTwo;
        this.absoluteDifference = Math.abs(scoreOne - scoreTwo);
    }

    @Override
    public boolean isValidScore(final int scoreOne, final int scoreTwo) {

        calculateValues(scoreOne, scoreTwo);

        if (highScore > MAX_SCORE) {
            return false;
        }

        if (highScore > MIN_WIN_SCORE && absoluteDifference > WIN_MARGIN) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidResult(final int scoreOne, final int scoreTwo) {

        calculateValues(scoreOne, scoreTwo);

        final boolean straightWin = highScore >= MIN_WIN_SCORE && absoluteDifference >= WIN_MARGIN;
        final boolean winByOneAtThirty = highScore == MAX_SCORE && absoluteDifference == 1;

        return isValidScore(scoreOne, scoreTwo) && (straightWin || winByOneAtThirty);
    }

}

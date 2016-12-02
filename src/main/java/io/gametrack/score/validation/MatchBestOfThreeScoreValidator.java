package io.gametrack.score.validation;

/**
 * @author Kevin Sutton
 */
public class MatchBestOfThreeScoreValidator implements ScoreValidator {

    @Override
    public boolean isValidScore(int scoreOne, int scoreTwo) {
        return scoreOne + scoreTwo <= 3 && scoreOne < 3 && scoreTwo < 3;
    }

    @Override
    public boolean isValidResult(int scoreOne, int scoreTwo) {
        return isValidScore(scoreOne, scoreTwo) &&
                (scoreOne == 2 || scoreTwo == 2);
    }
}

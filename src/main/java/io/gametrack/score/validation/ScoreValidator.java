package io.gametrack.score.validation;

/**
 * @author Kevin Sutton
 */
public interface ScoreValidator {
    boolean isValidScore(int scoreOne, int scoreTwo);
    boolean isValidResult(int scoreOne, int scoreTwo);
}

package io.gametrack.score;

/**
 * @author Kevin Sutton
 */
public class ScorePair {
    private final int scoreOne;
    private final int scoreTwo;

    public ScorePair(int scoreOne, int scoreTwo) {
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }

    public int getScoreOne() {
        return scoreOne;
    }

    public int getScoreTwo() {
        return scoreTwo;
    }
}

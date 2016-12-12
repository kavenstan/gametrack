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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScorePair)) return false;

        ScorePair scorePair = (ScorePair) o;

        if (getScoreOne() != scorePair.getScoreOne()) return false;
        return getScoreTwo() == scorePair.getScoreTwo();

    }

    @Override
    public int hashCode() {
        int result = getScoreOne();
        result = 31 * result + getScoreTwo();
        return result;
    }

    @Override
    public String toString() {
        return scoreOne + "-" + scoreTwo;
    }
}

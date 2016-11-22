package io.gametrack.score.model;

/**
 * @author Kevin Sutton
 */
public class FixtureScore implements Score {
    private int matchesWon;


    @Override
    public int getValue() {
        return matchesWon;
    }

    @Override
    public void setValue(int value) {
        this.matchesWon = value;
    }

    @Override
    public String toString() {
        return "FixtureScore{" +
                "matchesWon=" + matchesWon +
                '}';
    }
}

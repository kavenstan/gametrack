package io.gametrack.score.model;

/**
 * @author Kevin Sutton
 */
public class MatchScore implements Score {

    private int gamesWon;

    @Override
    public int getValue() {
        return gamesWon;
    }

    @Override
    public void setValue(int value) {
        this.gamesWon = value;
    }

    @Override
    public String toString() {
        return "MatchScore{" +
                "gamesWon=" + gamesWon +
                '}';
    }
}

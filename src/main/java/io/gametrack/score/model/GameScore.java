package io.gametrack.score.model;


/**
 * @author Kevin Sutton
 */
public class GameScore implements Score {

    private int points;

    @Override
    public int getValue() {
        return points;
    }

    @Override
    public void setValue(int value) {
        this.points = value;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "points=" + points +
                '}';
    }
}

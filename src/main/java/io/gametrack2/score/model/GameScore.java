package io.gametrack2.score.model;


import io.gametrack2.entrant.Entrant;

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
    public Entrant getEntrant() {
        return null;
    }

    @Override
    public void setEntrant(Entrant entrant) {

    }

    @Override
    public String toString() {
        return "GameScore{" +
                "points=" + points +
                '}';
    }
}

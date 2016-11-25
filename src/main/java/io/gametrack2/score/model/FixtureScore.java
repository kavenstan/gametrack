package io.gametrack2.score.model;

import io.gametrack2.entrant.Entrant;

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
    public Entrant getEntrant() {
        return null;
    }

    @Override
    public void setEntrant(Entrant entrant) {

    }

    @Override
    public String toString() {
        return "FixtureScore{" +
                "matchesWon=" + matchesWon +
                '}';
    }
}

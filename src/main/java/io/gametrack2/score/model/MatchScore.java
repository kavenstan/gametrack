package io.gametrack2.score.model;

import io.gametrack2.entrant.Entrant;

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
    public Entrant getEntrant() {
        return null;
    }

    @Override
    public void setEntrant(Entrant entrant) {

    }

    @Override
    public String toString() {
        return "MatchScore{" +
                "gamesWon=" + gamesWon +
                '}';
    }
}

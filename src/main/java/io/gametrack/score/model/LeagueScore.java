package io.gametrack.score.model;

/**
 * @author Kevin Sutton
 */
public class LeagueScore implements Score {

    private int leaguePoints;

    @Override
    public int getValue() {
        return leaguePoints;
    }

    @Override
    public void setValue(int value) {
        this.leaguePoints = value;
    }
}

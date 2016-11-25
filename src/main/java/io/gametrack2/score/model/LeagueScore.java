package io.gametrack2.score.model;

import io.gametrack2.entrant.Entrant;

/**
 * @author Kevin Sutton
 */
public class LeagueScore implements Score, Comparable<LeagueScore> {

    private Entrant entrant;

    private int leaguePoints = 0;
    private int matchesWon = 0;
    private int gamesWon = 0;
    private int pointsWon = 0;

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    @Override
    public int getValue() {
        return leaguePoints;
    }

    @Override
    public void setValue(int value) {
        this.leaguePoints = value;
    }

    @Override
    public int compareTo(LeagueScore o) {
        if (leaguePoints - o.leaguePoints != 0) {
            return o.leaguePoints - leaguePoints;
        }
        if (matchesWon - o.matchesWon != 0) {
            return o.matchesWon - matchesWon;
        }
        if (gamesWon - o.gamesWon != 0) {
            return o.gamesWon - gamesWon;
        }
        return o.pointsWon - pointsWon;
    }
}

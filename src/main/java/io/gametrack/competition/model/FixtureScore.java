package io.gametrack.competition.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class FixtureScore {
    private int amountMatchesWon = 0;
    private List<MatchScore> matchScores = new ArrayList<>();

    public int getAmountMatchesWon() {
        return amountMatchesWon;
    }

    public void setAmountMatchesWon(int amountMatchesWon) {
        this.amountMatchesWon = amountMatchesWon;
    }

    public List<MatchScore> getMatchScores() {
        return matchScores;
    }

    public void setMatchScores(List<MatchScore> matchScores) {
        this.matchScores = matchScores;
    }
}

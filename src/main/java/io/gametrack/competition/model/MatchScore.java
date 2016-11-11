package io.gametrack.competition.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class MatchScore {
    private int amountGamesWon = 0;
    private List<GameScore> gameScores = new ArrayList<>();

    public int getAmountGamesWon() {
        return amountGamesWon;
    }

    public void setAmountGamesWon(int amountGamesWon) {
        this.amountGamesWon = amountGamesWon;
    }

    public List<GameScore> getGameScores() {
        return gameScores;
    }

    public void setGameScores(List<GameScore> gameScores) {
        this.gameScores = gameScores;
    }
}

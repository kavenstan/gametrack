package io.gametrack.competition;

import io.gametrack.player.Side;

/**
 * @author Kevin Sutton
 */
public class Game extends Contest {

    public Game() {
        super();
        scores = new int [2];
    }



    @Override
    public void incrementScore(Side side) {
        scores[sideScoreIndex(side)]++;
        if (winConditionsMet()) {
            this.state = ContestState.WON;
            end();
        }
    }

    protected boolean winConditionsMet() {
        final int minPointsToWin = 21;
        if (scores[0] < minPointsToWin && scores[1] < minPointsToWin) {
            return false;
        }
        final int maxPointsPossible = 30;
        if (scores[0] >= maxPointsPossible || scores[1] >= maxPointsPossible) {
            return true;
        }

        int absoluteDifference = Math.abs(scores[0] - scores[1]);
        return absoluteDifference >= 2;
    }

}

package io.gametrack.competition.model;

import io.gametrack.competition.model.enums.ContestState;
import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.GameScore;
import io.gametrack.score.model.Score;

/**
 * @author Kevin Sutton
 */
public class Game extends Contest {

    @Override
    public Score calculateScore(Entrant entrant) {
        return getScore(entrant);
    }

    @Override
    public void updateScores() {

    }

    @Override
    public void checkConditions() {
        Entrant entrantOne = getEntrants().get(0);
        Entrant entrantTwo = getEntrants().get(1);

        int scoreOne = getScore(entrantOne).getValue();
        int scoreTwo = getScore(entrantTwo).getValue();

        int difference = scoreOne - scoreTwo;
        int absoluteDifference = Math.abs(difference);

        boolean outrightWin = scoreOne == 30 || scoreTwo == 30;
        boolean normalWin = (scoreOne >= 21 || scoreTwo >= 21) && absoluteDifference >= 2;

        if (outrightWin || normalWin) {
            setWinner(scoreOne > scoreTwo ? entrantOne : entrantTwo);
            logger.info("[{}] won game.", getWinner());
            setState(ContestState.WON);
        }
    }

    @Override
    public String toString() {
        String buf = "Game: ";
        buf += "Status: " + getState();
        if (getWinner() != null) {
            buf += ", Winner: [" + winner.getName() + "]";
        }
        buf += ", Participants: " + getEntrants().get(0).getName() + " vs " + getEntrants().get(1).getName();
        buf += ", Score: " + getScore(getEntrants().get(0)).getValue() + "-" + getScore(getEntrants().get(1)).getValue();
        return buf;
    }
}

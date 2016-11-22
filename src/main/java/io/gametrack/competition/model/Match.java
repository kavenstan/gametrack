package io.gametrack.competition.model;

import io.gametrack.competition.model.enums.ContestState;
import io.gametrack.competition.model.enums.MatchType;
import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.MatchScore;
import io.gametrack.score.model.Score;

/**
 * @author Kevin Sutton
 */
public class Match extends Contest {
    private final MatchType matchType;

    @Override
    public void updateScores() {
        for (Entrant entrant : getEntrants()) {
            setScore(entrant, calculateScore(entrant));
        }
        checkConditions();
    }

    @Override
    public Score calculateScore(Entrant entrant) {

        int gamesWon = (int) children.stream()
                .filter(g -> g.getState().getStateType().equals(ContestState.StateType.COMPLETE)
                        && g.getWinner() != null
                        && g.getWinner().equals(entrant))
                .count();

        Score matchScore = new MatchScore();
        matchScore.setValue(gamesWon);
        return matchScore;
    }

    @Override
    public void checkConditions() {
        for (Entrant entrant : getEntrants()) {
            if (getScore(entrant).getValue() == 2) {
                setWinner(entrant);
                logger.info("[{}] won match.", entrant);
                setState(ContestState.WON);
                return;
            }
        }
    }

    public Match(MatchType matchType) {
        super();
        this.matchType = matchType;
    }

    public MatchType getMatchType() {
        return matchType;
    }


    @Override
    public String toString() {
        String buf = "Match: ";
        buf += "Status: " + getState();
        if (getWinner() != null) {
            buf += ", Winner: [" + winner.getName() + "]";
        }
        buf += ", Participants: " + getEntrants().get(0).getName() + " vs " + getEntrants().get(1).getName();
        buf += ", Score: " + getScore(getEntrants().get(0)).getValue() + "-" + getScore(getEntrants().get(1)).getValue();
        return buf;
    }
}

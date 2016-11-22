package io.gametrack.competition.model;

import io.gametrack.competition.model.enums.ContestState;
import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.FixtureScore;
import io.gametrack.score.model.MatchScore;
import io.gametrack.score.model.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class Fixture extends Contest {

    private FixtureType fixtureType;

    public FixtureType getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    @Override
    public void updateScores() {
        for (Entrant entrant : getEntrants()) {
            setScore(entrant, calculateScore(entrant));
        }
        checkConditions();
    }

    @Override
    public Score calculateScore(Entrant entrant) {
        int matchesWon = (int) children.stream()
                .filter(m -> m.getState().getStateType().equals(ContestState.StateType.COMPLETE)
                        && m.getWinner() != null
                        && entrant.getPlayers().containsAll(m.getWinner().getPlayers()))
                .count();

        Score fixtureScore = new FixtureScore();
        fixtureScore.setValue(matchesWon);
        return fixtureScore;
    }

    @Override
    public void checkConditions() {
        Optional<Contest> notWon = children.stream()
                .filter(g -> !g.getState().getStateType().equals(ContestState.StateType.COMPLETE))
                .findAny();

        Entrant entrantOne = getEntrants().get(0);
        Entrant entrantTwo = getEntrants().get(1);

        int scoreOne = getScore(entrantOne).getValue();
        int scoreTwo = getScore(entrantTwo).getValue();

        if (!notWon.isPresent()) {

            if (scoreOne != scoreTwo) {
                setState(ContestState.WON);
                if (scoreOne > scoreTwo) {
                    setWinner(entrantOne);
                }
                else if (scoreOne < scoreTwo) {
                    setWinner(entrantTwo);
                }
            }
            else {
                setState(ContestState.DRAWN);
            }
            logger.info("Fixture [{}] is complete", this);
        }
    }



}

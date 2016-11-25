package io.gametrack2.competition.model;

import io.gametrack.competition.ContestState;
import io.gametrack2.entrant.Entrant;
import io.gametrack2.score.model.LeagueScore;
import io.gametrack2.score.model.Score;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Group of entrants in a league.
 *
 * @author Kevin Sutton
 */
public class LeagueGroup extends Contest {

    private static final Logger logger = LogManager.getLogger();

    private String name;

    public LeagueGroup(final String name) {
        logger.info("Creating group [{}]", name);
        this.name = name;
    }

    public String getName() {
        return name;
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

        int points = 0;
        for (Contest contest : getChildren()) {
            if (!contest.getEntrants().contains(entrant)) {
                continue;
            }
            if (contest.getState().getStateType().equals(ContestState.StateType.COMPLETE)) {
                if (contest.getWinner() != null && contest.getWinner().equals(entrant)) {
                    points += 2;
                }
                else if (contest.getState().equals(ContestState.DRAWN)) {
                    points += 1;
                }
            }
        }

        Score leagueScore = new LeagueScore();
        leagueScore.setValue(points);
        return leagueScore;
    }


    @Override
    public void checkConditions() {

        boolean incompleteFixtureExists = (!children.stream()
                .filter(f -> !f.getState().getStateType().equals(ContestState.StateType.COMPLETE))
                .findAny()
                .isPresent());

        if (incompleteFixtureExists) {
            setState(ContestState.WON);
        }

    }
}

package io.gametrack.competition.model;

import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.Score;
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

    @Override
    public Score calculateScore(Entrant entrant) {
        return null;
    }

    @Override
    public void updateScores() {

    }

    @Override
    public void checkConditions() {

    }
}

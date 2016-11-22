package io.gametrack.simulation;

import io.gametrack.competition.model.League;
import io.gametrack.competition.model.LeagueGroup;

/**
 * @author Kevin Sutton
 */
public class LeagueCreator {

    public static final int AMOUNT_GROUPS = 4;

    private LeagueGroupCreator groupCreator;

    public LeagueCreator() {
        this.groupCreator = new LeagueGroupCreator();
    }

    public League createLeague(String name) {
        League league = new League(name);
        for (int i = 0; i < AMOUNT_GROUPS; i++) {
            LeagueGroup group = groupCreator.createGroup("Group " + i);
            league.addGroup(group);
        }
        return league;
    }

}

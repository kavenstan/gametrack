package io.gametrack.competition;

import java.util.List;

/**
 * Created by kevin
 * 10/11/2016
 */
public class League implements Tournament {
    List<LeagueGroup> groups;

    @Override
    public Entrant getWinner() {
        return null;
    }

    @Override
    public List<Entrant> getEntrants() {
        return null;
    }
}

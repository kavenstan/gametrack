package io.gametrack.competition.model;

import io.gametrack.entrant.Entrant;

import java.util.List;

/**
 * Interface to represent any tournament
 *
 * @author Kevin Sutton
 */
public class Tournament {
    protected List<Entrant> entrants;


    final public void addEntrant(final Entrant entrant) {
        entrants.add(entrant);
    }

    final public boolean removeEntrant(final Entrant entrant) {
        return entrants.remove(entrant);
    }

    final public List<Entrant> getEntrants() {
        return entrants;
    }
}

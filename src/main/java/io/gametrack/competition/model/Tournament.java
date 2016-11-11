package io.gametrack.competition.model;

import java.util.List;

/**
 * Interface to represent any tournament
 *
 * @author Kevin Sutton
 */
public abstract class Tournament {
    protected List<Entrant> entrants;

    public abstract Entrant getWinner();

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

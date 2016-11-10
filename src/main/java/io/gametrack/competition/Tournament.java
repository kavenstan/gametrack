package io.gametrack.competition;

import java.util.List;

/**
 * Interface to represent any tournament
 *
 * @author Kevin Sutton
 */
public interface Tournament {
    Entrant getWinner();
    List<Entrant> getEntrants();
}

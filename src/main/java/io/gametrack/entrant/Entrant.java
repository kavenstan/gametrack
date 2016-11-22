package io.gametrack.entrant;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface Entrant {
    String getName();
    List<Player> getPlayers();
    void addPlayer(Player player);
}

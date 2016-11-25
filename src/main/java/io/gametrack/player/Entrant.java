package io.gametrack.player;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface Entrant {
    List<Player> getPlayers();
    void addPlayer(Player player);
}

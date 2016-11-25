package io.gametrack2.entrant;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface Entrant {
    String getName();
    List<Player> getPlayers();
    void addPlayer(Player player);
}

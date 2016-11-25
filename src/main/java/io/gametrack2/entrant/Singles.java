package io.gametrack2.entrant;

import java.util.Collections;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class Singles implements Entrant {

    private Player player;

    @Override
    public String getName() {
        return player.getFullName();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.singletonList(player);
    }

    @Override
    public void addPlayer(Player player) {
        if (this.player != null) {
            throw new RuntimeException("Player already exists");
        }
        this.player = player;
    }

    @Override
    public String toString() {
        return "Singles{" +
                getName() +
                '}';
    }
}

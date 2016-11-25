package io.gametrack.player.team;

import io.gametrack.player.Entrant;
import io.gametrack.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public abstract class Team implements Entrant {

    protected Player captain;
    protected List<Player> players;

    protected Team() {
        players = new ArrayList<>();
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() >= getTeamSize()) {
            throw new RuntimeException("Can not add another player - Max team size reached");
        }
        players.add(player);
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void setPlayers(List<Player> players) {
        players.forEach(this::addPlayer);
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    protected abstract int getTeamSize();

}

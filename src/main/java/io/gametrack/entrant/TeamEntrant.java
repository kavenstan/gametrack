package io.gametrack.entrant;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public class TeamEntrant implements Entrant {

    private Entrant entrant;
    private Team team;

    @Override
    public String getName() {
        return entrant.getName();
    }

    @Override
    public List<Player> getPlayers() {
        return entrant.getPlayers();
    }

    @Override
    public void addPlayer(Player player) {
        entrant.addPlayer(player);
    }

    public Team getTeam() {
        return team;
    }
}

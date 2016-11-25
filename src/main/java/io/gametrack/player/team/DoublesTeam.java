package io.gametrack.player.team;

import io.gametrack.player.Player;
import io.gametrack.player.Gender;

/**
 * @author Kevin Sutton
 */
public abstract class DoublesTeam extends Team {

    private final static int DOUBLES_TEAM_SIZE = 8;

    @Override
    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player must not be null");
        }
        if (!player.getGender().equals(getTeamGender())) {
            throw new RuntimeException("Can not add non-male to mens doubles team");
        }
        super.addPlayer(player);
    }

    @Override
    protected int getTeamSize() {
        return DOUBLES_TEAM_SIZE;
    }

    public abstract Gender getTeamGender();

}

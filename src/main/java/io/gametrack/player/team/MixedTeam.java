package io.gametrack.player.team;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.player.Gender;
import io.gametrack.player.Player;

/**
 * @author Kevin Sutton
 */
public class MixedTeam extends Team {
    private final static int MIXED_TEAM_SIZE = 12;

    private final static int GENDER_PER_TEAM = 6;

    @Override
    protected int getTeamSize() {
        return MIXED_TEAM_SIZE;
    }

    @Override
    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player must not be null");
        }
        if (amountGenderOnTeam(player.getGender()) >= GENDER_PER_TEAM) {
            throw new GametrackException(GametrackExceptionType.PLAYER_LIMIT_REACHED, "Can not add more " + player.getGender() + " to team.");
        }
        super.addPlayer(player);
    }

    private int amountGenderOnTeam(Gender gender) {
        return (int) getPlayers().stream().filter(p -> p.getGender().equals(gender)).count();
    }
}

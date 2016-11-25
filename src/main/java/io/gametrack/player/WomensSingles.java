package io.gametrack.player;

import io.gametrack.player.team.Team;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class WomensSingles extends Singles {
    private Player player;

    public WomensSingles(Player player) {
        if (!player.getGender().equals(Gender.FEMALE)) {
            throw new RuntimeException("Assigned non-female to WomensSingles");
        }
        this.player = player;
    }

    @Override
    public Optional<Team> getTeam() {
        return null;
    }
}

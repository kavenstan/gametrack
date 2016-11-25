package io.gametrack.player;

import io.gametrack.player.team.Team;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class MensSingles extends Singles {

    private Player player;

    public MensSingles(Player player) {
        if (!player.getGender().equals(Gender.MALE)) {
            throw new RuntimeException("Assigned non-male to MensSingles");
        }
        this.player = player;
    }

    @Override
    public Optional<Team> getTeam() {
        return null;
    }
}

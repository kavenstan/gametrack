package io.gametrack.player;

import io.gametrack.player.team.Team;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public interface Side extends Entrant {
    Optional<Team> getTeam();
}

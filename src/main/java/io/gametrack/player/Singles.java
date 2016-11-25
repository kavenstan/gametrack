package io.gametrack.player;

import io.gametrack.GametrackException;
import io.gametrack.GametrackExceptionType;
import io.gametrack.player.team.Team;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public abstract class Singles implements Side {

    private Team team;
    private Player player;

    public Player getPlayer() {
        return this.player;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public Optional<Team> getTeam() {
        return team != null ? Optional.of(team): Optional.empty();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.singletonList(player);
    }

    @Override
    public void addPlayer(Player player) {
        if (this.player == null) {
            throw new GametrackException(GametrackExceptionType.PLAYER_LIMIT_REACHED, "Can not add second player to singles side");
        }
        this.player = player;
    }
}

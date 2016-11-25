package io.gametrack.player;

import io.gametrack.player.team.Team;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public abstract class Doubles implements Side {

    protected Team team;

    protected final Player[] players;

    public Doubles(Player playerOne, Player playerTwo) {
        players = new Player[2];
        this.players[0] = playerOne;
        this.players[1] = playerTwo;
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(Arrays.asList(players));
    }

    @Override
    public Optional<Team> getTeam() {
        return team != null ? Optional.of(team): Optional.empty();
    }

}

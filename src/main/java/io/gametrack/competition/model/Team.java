package io.gametrack.competition.model;

import io.gametrack.user.Player;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public class Team extends Entrant {
    private List<Player> squad;

    public Team(String name) {
        this.name = name;
    }

}

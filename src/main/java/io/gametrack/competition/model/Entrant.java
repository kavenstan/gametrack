package io.gametrack.competition.model;

import io.gametrack.user.Player;

import java.util.List;

/**
 * Interface to represent any competitor/team in a tournament
 *
 * @author Kevin Sutton
 */
public class Entrant extends BaseObject {
    protected String name;
    private List<Player> players;

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package io.gametrack.competition.web;

import io.gametrack.player.Player;
import io.gametrack.player.Side;

import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class SimpleSideDTO {
    private Long id;
    private String name;

    public SimpleSideDTO(Side side) {
        this.id = side.getId();
        this.name = side.getPlayers().stream().map(Player::getFamilyName).collect(Collectors.joining("/"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

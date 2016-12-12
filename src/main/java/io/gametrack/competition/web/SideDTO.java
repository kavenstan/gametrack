package io.gametrack.competition.web;

import io.gametrack.player.Side;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class SideDTO {
    private Long id;
    private List<PlayerDTO> players;

    public SideDTO(Side side) {
        this.id = side.getId();
        this.setPlayers(side.getPlayers().stream().map(PlayerDTO::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}

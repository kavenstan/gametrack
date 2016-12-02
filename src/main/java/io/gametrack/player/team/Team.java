package io.gametrack.player.team;

import io.gametrack.core.model.BaseEntity;
import io.gametrack.player.Player;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kevin Sutton
 */
@Entity
public class Team extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="id_game")
    private Player captain;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="team_player", joinColumns = @JoinColumn(name="id_team"), inverseJoinColumns=@JoinColumn(name="id_player"))
    private Set<Player> players;

    public Team() {
        players = new HashSet<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public void setPlayers(List<Player> players) {
        players.forEach(this::addPlayer);
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }


}

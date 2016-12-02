package io.gametrack.player;

import io.gametrack.core.model.BaseEntity;
import io.gametrack.player.team.Team;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "side")
public class Side extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="side_player", joinColumns = @JoinColumn(name="id_side"), inverseJoinColumns=@JoinColumn(name="id_player"))
    private Set<Player> players;

    @ManyToOne
    @JoinColumn(name="id_team")
    private Team team;

    private Date createdOn;

    public Side() {
        this.players = new HashSet<>();
        this.createdOn = new Date();
    }

    public Optional<Team> getTeam() {
        return team != null
                ? Optional.of(team)
                : Optional.empty();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}

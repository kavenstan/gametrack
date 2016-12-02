package io.gametrack.competition.domain.entity;

import io.gametrack.player.Side;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name="score_game")
public class GameScore extends Score {

    @ManyToOne
    @JoinColumn(name="id_game")
    private Game game;

    public GameScore(Side side) {
        super(side);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

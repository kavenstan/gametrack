package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreLister;
import io.gametrack.competition.domain.ScoreSystem;
import io.gametrack.player.Side;
import io.gametrack.player.Sides;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "game")
public class Game extends Contest implements ScoreLister {

    @ManyToOne
    @JoinColumn(name="id_match")
    private Match match;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<GameScore> scores;

    protected Game(final Match match) {
        super();
        this.match = match;
        this.scores = new ArrayList<>();
    }

    public List<GameScore> getScores() {
        return Collections.unmodifiableList(scores);
    }

    @Override
    public void setScore(int side, int newValue) {
        this.scores.get(side).setScore(newValue);
    }

    public Match getMatch() {
        return match;
    }

    public GameType getGameType() {
        return match.getGameType();
    }

    public static class Builder {

        private Match match;
        private Sides sides;
        private GameType gameType;
        private Side homeSide;
        private ScoreSystem scoreSystem;

        public Builder(Match match) {
            this.match = match;
        }

        public Game build() {
            Game game = new Game(this.match);
            game.scores.add(new GameScore(match.getScores().get(0).getSide()));
            game.scores.add(new GameScore(match.getScores().get(1).getSide()));
            game.setHomeSide(this.match.homeSide);
            game.setScoreSystem(this.scoreSystem);
            return game;
        }

        public Builder withScoreSystem(ScoreSystem scoreSystem) {
            this.scoreSystem = scoreSystem;
            return this;
        }

    }
}

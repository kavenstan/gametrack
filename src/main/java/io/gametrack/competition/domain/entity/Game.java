package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreLister;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.player.Side;
import io.gametrack.score.domain.entity.GameScore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    protected Game() {}

    protected Game(final Match match, final ScoreSystemType scoreSystemType) {
        super();
        this.match = match;
        this.scoreSystemType = scoreSystemType;
        this.scores = new ArrayList<>();
        addScore(match.getScores().get(SIDE_ONE).getSide());
        addScore(match.getScores().get(SIDE_TWO).getSide());
    }

    public List<GameScore> getScores() {
        return Collections.unmodifiableList(scores);
    }

    private void addScore(Side side) {
        GameScore gameScore = new GameScore(side);
        gameScore.setGame(this);
        this.scores.add(gameScore);
    }

    @Override
    public void setScore(int side, int newValue) {
        this.scores.get(side).setScore(newValue);
    }

    @Override
    public Optional<Side> getHomeSide() {
        return match.getHomeSide();
    }

    public Match getMatch() {
        return match;
    }

    public GameType getGameType() {
        return match.getGameType();
    }

    public static class Builder {

        private final Match match;
        private final ScoreSystemType scoreSystemType;

        public Builder(Match match, ScoreSystemType scoreSystemType) {
            this.match = match;
            this.scoreSystemType = scoreSystemType;
        }

        public Game build() {
            Game game = new Game(this.match, this.scoreSystemType);
            game.setHomeSide(this.match.homeSide);
            this.match.getGames().add(game);
            return game;
       }

    }
}

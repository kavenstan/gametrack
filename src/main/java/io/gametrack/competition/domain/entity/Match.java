package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreLister;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.player.Side;
import io.gametrack.player.Sides;
import io.gametrack.score.domain.entity.MatchScore;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Kevin Sutton
 */
@Entity
@Table(name = "match")
public class Match extends Contest implements ScoreLister {

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private List<Game> games;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private List<MatchScore> scores;

    @ManyToOne
    @JoinColumn(name="id_fixture")
    private Fixture fixture;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    protected Match(GameType gameType, ScoreSystemType scoreSystemType) {
        super();
        this.scoreSystemType = scoreSystemType;
        this.gameType = gameType;
        this.games = new ArrayList<>();
    }

    public List<Game> getGames() {
        return games;
    }

    public List<MatchScore> getScores() {
        return scores;
    }

    @Override
    public void setScore(int side, int newValue) {
        this.scores.get(side).setScore(newValue);
    }

    public GameType getGameType() {
        return gameType;
    }

    public Optional<Fixture> getFixture() {
        return fixture != null ? Optional.of(fixture) : Optional.empty();
    }

    public static class Builder {

        private Side homeSide;

        private final GameType gameType;
        private final ScoreSystemType scoreSystemType;
        private final Sides sides;

        public Builder(GameType gameType, ScoreSystemType scoreSystemType, Sides sides) {
            this.gameType = gameType;
            this.scoreSystemType = scoreSystemType;
            this.sides = sides;
        }

        public Match build() {

            Match match = new Match(gameType, scoreSystemType);

            match.scores = Arrays.asList(
                    new MatchScore(sides != null ? sides.getSideOne() : null),
                    new MatchScore(sides != null ? sides.getSideTwo() : null)
            );

            match.setHomeSide(this.homeSide);

            return match;
        }

        public Builder withHomeSide(Side homeSide) {
            this.homeSide = homeSide;
            return this;
        }

    }

}

package io.gametrack.competition.domain.entity;

import io.gametrack.competition.domain.GameType;
import io.gametrack.competition.domain.ScoreLister;
import io.gametrack.competition.domain.ScoreSystem;
import io.gametrack.player.Side;
import io.gametrack.player.Sides;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
@Entity
public class Match extends Contest implements ScoreLister {

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private List<Game> games;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private List<MatchScore> scores;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    protected Match(GameType gameType) {
        super();
        this.gameType = gameType;
        this.scores = new ArrayList<>();
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


    public static class Builder {

        private Sides sides;
        private GameType gameType;
        private Side homeSide;
        private ScoreSystem scoreSystem;

        public Builder() {
        }

        public Match build() {
            Match match = new Match(gameType);
            match.scores.add(new MatchScore(sides.getSideOne()));
            match.scores.add(new MatchScore(sides.getSideTwo()));
            match.setHomeSide(this.homeSide);
            match.setScoreSystem(this.scoreSystem);
            return match;
        }

        public Builder withSides(Sides sides) {
            this.sides = sides;
            return this;
        }

        public Builder withType(GameType gameType) {
            this.gameType = gameType;
            return this;
        }

        public Builder withHomeSide(Side homeSide) {
            this.homeSide = homeSide;
            return this;
        }

        public Builder withScoreSystem(ScoreSystem scoreSystem) {
            this.scoreSystem = scoreSystem;
            return this;
        }

    }

}

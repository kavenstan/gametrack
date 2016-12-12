package io.gametrack.competition.web;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.competition.domain.entity.Match;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class MatchDTO implements Serializable {
    private Long id;
    private List<GameDTO> games;
    private ContestState state;
    private ScoreSystemType scoreSystem;
    private List<ScoreDTO> scores;

    public MatchDTO(Match match) {
        this.id = match.getId();
        this.state = match.getState();
        this.scoreSystem = match.getScoreSystemType();
        this.scores = match.getScores().stream().map(ScoreDTO::new).collect(Collectors.toList());
        this.games = match.getGames().stream().map(GameDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }

    public ContestState getState() {
        return state;
    }

    public void setState(ContestState state) {
        this.state = state;
    }

    public ScoreSystemType getScoreSystem() {
        return scoreSystem;
    }

    public void setScoreSystem(ScoreSystemType scoreSystem) {
        this.scoreSystem = scoreSystem;
    }

    public List<ScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<ScoreDTO> scores) {
        this.scores = scores;
    }
}

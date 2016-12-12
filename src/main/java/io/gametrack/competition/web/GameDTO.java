package io.gametrack.competition.web;

import io.gametrack.competition.domain.ContestState;
import io.gametrack.competition.domain.ScoreSystemType;
import io.gametrack.competition.domain.entity.Game;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class GameDTO {
    private Long id;
    private List<ScoreDTO> scores;
    private SideDTO winner;
    private ContestState state;
    private ScoreSystemType scoreSystem;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.scores = game.getScores().stream().map(ScoreDTO::new).collect(Collectors.toList());
        if (game.getWinner().isPresent()) {
            this.winner = new SideDTO(game.getWinner().get());
        }
        this.state = game.getState();
        this.scoreSystem = game.getScoreSystemType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<ScoreDTO> scores) {
        this.scores = scores;
    }

    public SideDTO getWinner() {
        return winner;
    }

    public void setWinner(SideDTO winner) {
        this.winner = winner;
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
}

package io.gametrack.competition.web;

import io.gametrack.competition.domain.entity.Game;

/**
 * @author Kevin Sutton
 */
public class GameResultDTO {
    private Long id;
    private String score;

    public GameResultDTO(Game game) {
        this.id = game.getId();
        this.score = game.getScorePair().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

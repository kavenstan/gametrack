package io.gametrack.competition.web;

import io.gametrack.score.domain.entity.Score;

import java.io.Serializable;

/**
 * @author Kevin Sutton
 */
public class ScoreDTO implements Serializable {
    private Long id;
    private SideDTO side;
    private Integer score;

    public ScoreDTO(Score score) {
        this.id = score.getId();
        this.side = new SideDTO(score.getSide());
        this.score = score.getScore();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SideDTO getSide() {
        return side;
    }

    public void setSide(SideDTO side) {
        this.side = side;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

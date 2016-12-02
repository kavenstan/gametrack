package io.gametrack.competition.domain.dto;

/**
 * @author Kevin Sutton
 */
public class SideScoreDTO {
    private Long sideId;
    private Integer score;

    public Long getSideId() {
        return sideId;
    }

    public void setSideId(Long sideId) {
        this.sideId = sideId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

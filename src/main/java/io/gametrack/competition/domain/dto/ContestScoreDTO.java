package io.gametrack.competition.domain.dto;

import io.gametrack.score.ScorePair;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public class ContestScoreDTO {
    private Long contestId;
    private List<SideScoreDTO> sideScores;

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public List<SideScoreDTO> getSideScores() {
        return sideScores;
    }

    public void setSideScores(List<SideScoreDTO> sideScores) {
        this.sideScores = sideScores;
    }

    public ScorePair getScorePair() {
        return new ScorePair(getScoreOneValue(), getScoreTwoValue());
    }

    public int getScoreOneValue() {
        return getSideScores().get(0).getScore();
    }

    public int getScoreTwoValue() {
        return getSideScores().get(1).getScore();
    }
}

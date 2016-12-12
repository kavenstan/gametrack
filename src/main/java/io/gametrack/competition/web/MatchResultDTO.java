package io.gametrack.competition.web;

import io.gametrack.competition.domain.entity.Match;
import io.gametrack.score.domain.entity.MatchScore;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Sutton
 */
public class MatchResultDTO {
    private Long id;
    private List<SimpleSideDTO> sides;
    private List<GameResultDTO> gameResults;
    private String score;

    public MatchResultDTO(Match match) {
        this.id = match.getId();
        this.score = match.getScorePair().toString();
        this.gameResults = match.getGames()
                .stream()
                .map(GameResultDTO::new)
                .collect(Collectors.toList());
        this.sides = match.getScores()
                .stream()
                .map(MatchScore::getSide)
                .map(SimpleSideDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SimpleSideDTO> getSides() {
        return sides;
    }

    public void setSides(List<SimpleSideDTO> sides) {
        this.sides = sides;
    }

    public List<GameResultDTO> getGameResults() {
        return gameResults;
    }

    public void setGameResults(List<GameResultDTO> gameResults) {
        this.gameResults = gameResults;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGameScores() {
        return this.getGameResults().stream().map(GameResultDTO::getScore).collect(Collectors.joining(" "));
    }
}

package io.gametrack.competition.web;

import io.gametrack.competition.domain.entity.Match;

/**
 * @author Kevin Sutton
 */
public class MatchDTO {
    private Long id;

    public MatchDTO(Match match) {
        this.id = match.getId();
    }
}

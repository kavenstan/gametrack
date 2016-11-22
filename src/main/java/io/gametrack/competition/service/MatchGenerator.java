package io.gametrack.competition.service;

import io.gametrack.competition.model.Fixture;
import io.gametrack.competition.model.Match;
import io.gametrack.competition.model.enums.MatchType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class MatchGenerator {

    public List<Match> generateMatches(Fixture fixture) {

        List<Match> matches = new ArrayList<>();

        for (MatchType matchType : MatchType.values()) {
            for (int i = 0; i < fixture.getFixtureType().getAmountMatches(matchType); i++) {
                Match match = new Match(matchType);
                match.setParent(fixture);
                matches.add(match);
            }
        }

        return matches;
    }

}

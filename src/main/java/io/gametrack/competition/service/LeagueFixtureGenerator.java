package io.gametrack.competition.service;

import io.gametrack.competition.model.Fixture;
import io.gametrack.competition.model.FixtureType;
import io.gametrack.competition.model.LeagueGroup;
import io.gametrack.competition.model.enums.MatchType;
import io.gametrack.entrant.Entrant;
import io.gametrack.score.model.FixtureScore;
import io.gametrack.score.model.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Sutton
 */
public class LeagueFixtureGenerator implements FixtureGenerator {

    private LeagueGroup leagueGroup;
    private FixtureType fixtureType;

    public LeagueFixtureGenerator(LeagueGroup leagueGroup) {
        this.leagueGroup = leagueGroup;

        fixtureType = new FixtureType("County Mixed League");
        fixtureType.setAmountMatches(MatchType.MENS_SINGLES, 1);
        fixtureType.setAmountMatches(MatchType.WOMENS_SINGLES, 1);
        fixtureType.setAmountMatches(MatchType.MENS_DOUBLES, 1);
        fixtureType.setAmountMatches(MatchType.WOMENS_DOUBLES, 1);
        fixtureType.setAmountMatches(MatchType.MIXED_DOUBLES, 3);
    }

    public List<Fixture> generateFixtures() {
        List<Fixture> fixtures = new ArrayList<>();

        List<Entrant> entrants = leagueGroup.getEntrants();

        for (int i = 0; i < entrants.size(); i++) {
            for (int j = i+1; j < entrants.size(); j++) {
                Entrant entrantOne = entrants.get(i);
                Entrant entrantTwo = entrants.get(j);

                Fixture fixture = new Fixture();
                fixture.setFixtureType(fixtureType);

                Map<Entrant, Score> scoreMap = new HashMap<>();
                scoreMap.put(entrantOne, new FixtureScore());
                scoreMap.put(entrantTwo, new FixtureScore());
                fixture.setScores(scoreMap);

                fixtures.add(fixture);
            }
        }

        return fixtures;
    }

}

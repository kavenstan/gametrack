package io.gametrack.competition.service;

import io.gametrack.competition.model.Entrant;
import io.gametrack.competition.model.Fixture;
import io.gametrack.competition.model.LeagueGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class LeagueFixtureGenerator implements FixtureGenerator {

    public LeagueFixtureGenerator(LeagueGroup league) {

    }

    public List<Fixture> generateFixtures(List<Entrant> entrants) {
        List<Fixture> fixtures = new ArrayList<>();

        for (int i = 0; i < entrants.size(); i++) {
            for (int j = i+1; j < entrants.size(); j++) {
                Entrant entrantOne = entrants.get(i);
                Entrant entrantTwo = entrants.get(j);

                Fixture fixture = new Fixture();
                fixture.setEntrantOne(entrantOne);
                fixture.setEntrantTwo(entrantTwo);
                fixtures.add(fixture);
            }
        }

        return fixtures;
    }

}

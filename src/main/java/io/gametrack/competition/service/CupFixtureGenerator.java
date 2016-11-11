package io.gametrack.competition.service;

import io.gametrack.competition.model.Entrant;
import io.gametrack.competition.model.Fixture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @author Kevin Sutton
 */
public class CupFixtureGenerator implements FixtureGenerator {

    private Random randomGenerator;

    public CupFixtureGenerator() {
        randomGenerator = new Random();
    }

    public List<Fixture> generateFixtures(List<Entrant> entrants) {

        List<Fixture> fixtures = new ArrayList<>();

        int totalFixturesInFirstRound = fixturesInRound(entrants.size());

        int fixturesToPlayInFirstRound = entrants.size() - totalFixturesInFirstRound;

        for (int i = 0; i < fixturesToPlayInFirstRound; i++) {
            Fixture fixture = new Fixture();

            fixture.setEntrantOne(pickRandomEntrant(entrants));
            fixture.setEntrantTwo(pickRandomEntrant(entrants));

            fixtures.add(fixture);
        }

        return fixtures;
    }

    private int fixturesInRound(int amtEntrants) {
        return (int) Math.ceil(Math.log(amtEntrants)/Math.log(2)) / 2;
    }

    private Entrant pickRandomEntrant(List<Entrant> entrants) {
        int index = randomGenerator.nextInt(entrants.size());
        Entrant entrant = entrants.get(index);
        entrants.remove(entrant);
        return entrant;
    }

}

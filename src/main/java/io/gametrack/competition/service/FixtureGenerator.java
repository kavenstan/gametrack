package io.gametrack.competition.service;

import io.gametrack.competition.model.Entrant;
import io.gametrack.competition.model.Fixture;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface FixtureGenerator {
    List<Fixture> generateFixtures(List<Entrant> entrants);
}

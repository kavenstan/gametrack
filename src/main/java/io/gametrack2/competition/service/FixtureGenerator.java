package io.gametrack2.competition.service;

import io.gametrack2.competition.model.Fixture;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface FixtureGenerator {
    List<Fixture> generateFixtures();
}

package io.gametrack.competition.service;

import io.gametrack.player.Side;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public interface ContestEvaluator {
    boolean isDraw();
    Optional<Side> winner();
}

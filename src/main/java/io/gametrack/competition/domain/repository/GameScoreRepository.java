package io.gametrack.competition.domain.repository;

import io.gametrack.score.domain.entity.GameScore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface GameScoreRepository extends CrudRepository<GameScore, Long> {
    GameScore findOne(Long id);
    List<GameScore> findAll();
}
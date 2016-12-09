package io.gametrack.competition.domain.repository;

import io.gametrack.score.domain.entity.MatchScore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface MatchScoreRepository extends CrudRepository<MatchScore, Long> {
    MatchScore findOne(Long id);
    List<MatchScore> findAll();
}
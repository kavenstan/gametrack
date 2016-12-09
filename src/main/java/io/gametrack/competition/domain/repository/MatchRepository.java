package io.gametrack.competition.domain.repository;

import io.gametrack.competition.domain.entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface MatchRepository extends CrudRepository<Match, Long> {
    Match findOne(Long id);
    List<Match> findAll();
}

package io.gametrack.competition.domain.repository;

import io.gametrack.competition.domain.entity.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface GameRepository extends CrudRepository<Game, Long> {
    Game findOne(Long id);
    List<Game> findAll();
}

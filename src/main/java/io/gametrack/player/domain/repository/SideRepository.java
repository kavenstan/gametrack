package io.gametrack.player.domain.repository;

import io.gametrack.player.Side;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface SideRepository extends CrudRepository<Side, Long> {
    Side findOne(Long id);
    List<Side> findAll();
}
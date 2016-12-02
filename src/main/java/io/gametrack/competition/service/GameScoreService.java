package io.gametrack.competition.service;

import io.gametrack.GametrackException;
import io.gametrack.competition.domain.entity.Game;
import io.gametrack.competition.domain.dto.ContestScoreDTO;
import io.gametrack.competition.domain.repository.GameDAO;
import io.gametrack.score.GameScoreModifier;

import javax.validation.Valid;

/**
 * @author Kevin Sutton
 */
public class GameScoreService {

    private final GameDAO gameDAO;
    private final GameScoreModifier gameScoreModifier;

    public GameScoreService(GameDAO gameDAO,
                            GameScoreModifier gameScoreModifier) {
        this.gameDAO = gameDAO;
        this.gameScoreModifier = gameScoreModifier;
    }

    // Set game score
    public void updateGameScore(@Valid ContestScoreDTO score) {

        // Check argument
        if (score == null || score.getContestId() == null || score.getSideScores() == null || score.getSideScores().size() != 2) {
            throw new IllegalArgumentException();
        }

        Game game = gameDAO.getById(score.getContestId());

        try {
            gameScoreModifier.modifyScore(game, score.getScorePair());
            gameDAO.save(game);
        }
        catch (GametrackException e) {
            e.printStackTrace();
        }

    }

}

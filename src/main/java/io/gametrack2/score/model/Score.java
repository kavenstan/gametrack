package io.gametrack2.score.model;

import io.gametrack2.entrant.Entrant;

/**
 * @author Kevin Sutton
 */
public interface Score {
    int getValue();
    void setValue(int value);
    Entrant getEntrant();
    void setEntrant(Entrant entrant);
}

package io.gametrack.entrant;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class Doubles implements Entrant {

    private Player playerOne;
    private Player playerTwo;

    public Doubles() {
        playerOne = null;
        playerTwo = null;
    }

    @Override
    public String getName() {
        String buf = playerOne != null ? playerOne.getFamilyName() : "?";
        buf += "/";
        buf += playerTwo != null ? playerTwo.getFamilyName() : "?";
        return buf;
    }

    @Override
    public List<Player> getPlayers() {
        return Arrays.asList(playerOne, playerTwo);
    }

    @Override
    public void addPlayer(Player player) {
        if (this.playerOne != null) {
            if (this.playerTwo != null) {
                throw new RuntimeException("Can't add third player to doubles");
            }
            this.playerTwo = player;
            return;
        }
        this.playerOne = player;
    }

    @Override
    public String toString() {
        return "Doubles{" +
                getName() +
                '}';
    }

}

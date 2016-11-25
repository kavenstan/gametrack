package io.gametrack2.entrant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Sutton
 */
public class Team implements Entrant {

    private static final Logger logger = LogManager.getLogger();

    private String name;
    private List<Player> players;

    public Team(String name) {
        logger.debug("Creating team [{}]", name);
        this.name = name;
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team{" +
                getName() +
                '}';
    }

}

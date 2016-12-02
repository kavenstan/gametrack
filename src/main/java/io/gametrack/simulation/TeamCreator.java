package io.gametrack.simulation;

import io.gametrack.player.Gender;
import io.gametrack.player.team.Team;

/**
 * @author Kevin Sutton
 */
public class TeamCreator {

    private PlayerCreator playerCreator;

    public TeamCreator() {
        this.playerCreator = new PlayerCreator();
    }

    public Team createTeam(String name, int numMale, int numFemale) {
        Team team = new Team();
        addPlayersToTeam(team, numMale, Gender.MALE);
        addPlayersToTeam(team, numFemale, Gender.FEMALE);
        return team;
    }

    private void addPlayersToTeam(Team team, int amount, Gender gender) {
        for (int i = 0; i < amount; i++) {
            team.getPlayers().add(playerCreator.createPlayer(gender));
        }
    }
}

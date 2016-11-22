package io.gametrack.simulation;

import io.gametrack.entrant.Team;
import io.gametrack.entrant.Gender;

/**
 * @author Kevin Sutton
 */
public class TeamCreator {

    private PlayerCreator playerCreator;

    public TeamCreator() {
        this.playerCreator = new PlayerCreator();
    }

    public Team createTeam(String name, int numMale, int numFemale) {
        Team team = new Team(name);
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

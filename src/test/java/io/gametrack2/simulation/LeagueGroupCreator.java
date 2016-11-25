package io.gametrack2.simulation;

import io.gametrack2.competition.model.LeagueGroup;
import io.gametrack2.entrant.Entrant;
import io.gametrack2.score.model.LeagueScore;

import static io.gametrack2.simulation.Utils.randomString;

/**
 * @author Kevin Sutton
 */
public class LeagueGroupCreator {
    private final static int MEN_PER_TEAM = 4;
    private final static int WOMEN_PER_TEAM = 4;
    private final static int TEAMS_PER_GROUP = 4;

    private final static String [] placeNames = {"Antrim","Armagh","Carlow","Cavan","Clare","Cork","Derry","Donegal","Down","Dublin","Fermanagh","Galway","Kerry","Kildare","Kilkenny","Laois","Leitrim","Limerick","Longford","Louth","Mayo","Meath","Monaghan","Offaly","Roscommon","Sligo","Tipperary","Tyrone","Waterford","Westmeath","Wexford","Wicklow"};
    private final static String [] clubSuffixes = {"United", "City", "BC", "Club", ""};


    private TeamCreator teamCreator;

    public LeagueGroupCreator() {
        teamCreator = new TeamCreator();
    }

    public LeagueGroup createGroup(String groupName) {
        LeagueGroup group = new LeagueGroup(groupName);
        for (int i = 0; i < TEAMS_PER_GROUP; i++) {
            Entrant team = teamCreator.createTeam(randomTeamName(), MEN_PER_TEAM, WOMEN_PER_TEAM);
            group.addEntrant(team, new LeagueScore());
        }
        return group;
    }

    private String randomTeamName() {
        return randomString(placeNames) + " " + randomString(clubSuffixes);
    }

}

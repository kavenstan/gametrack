package io.gametrack.competition.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin
 * 10/11/2016
 */
public class League {
    private List<LeagueGroup> groups = new ArrayList<>();
    private final String name;

    public League(String name) {
        this.name = name;
    }

    public List<LeagueGroup> getGroups() {
        return groups;
    }

    public void add(LeagueGroup group) {
        groups.add(group);
    }

    public String getName() {
        return name;
    }
}

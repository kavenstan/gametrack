package io.gametrack.competition.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin
 * 10/11/2016
 */
public class League {

    private static final Logger logger = LogManager.getLogger();

    private String name;

    private List<LeagueGroup> groups;

    public League(String name) {
        logger.info("Creating league: [{}]", name);
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public List<LeagueGroup> getGroups() {
        return groups;
    }

    public void addGroup(LeagueGroup group) {
        groups.add(group);
    }

}

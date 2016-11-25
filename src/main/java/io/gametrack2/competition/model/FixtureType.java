package io.gametrack2.competition.model;

import io.gametrack2.competition.model.enums.MatchType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin Sutton
 */
public class FixtureType {
    private String name;
    private Map<MatchType, Integer> matchTypeMap;

    public FixtureType(String name) {
        this.name = name;
        this.matchTypeMap = new HashMap<>();
    }

    public void setAmountMatches(MatchType matchType, int amount) {
        matchTypeMap.put(matchType, amount);
    }

    public int getAmountMatches(MatchType matchType) {
        return matchTypeMap.get(matchType) != null ? matchTypeMap.get(matchType) : 0;
    }

}

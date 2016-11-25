package io.gametrack2.competition.model.enums;

/**
 * @author Kevin Sutton
 */
public enum MatchType {
    MENS_SINGLES (MatchGender.MEN),
    WOMENS_SINGLES (MatchGender.WOMEN),
    MENS_DOUBLES (MatchGender.MEN),
    WOMENS_DOUBLES (MatchGender.WOMEN),
    MIXED_DOUBLES (MatchGender.MIXED);

    private final MatchGender matchGender;

    MatchType(MatchGender matchGender) {
        this.matchGender = matchGender;
    }

    public MatchGender getMatchGender() {
        return matchGender;
    }

    public enum MatchGender {
        MEN,
        WOMEN,
        MIXED
    }
}

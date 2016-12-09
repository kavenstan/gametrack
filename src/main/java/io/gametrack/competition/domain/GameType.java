package io.gametrack.competition.domain;

/**
 * @author Kevin Sutton
 */
public enum GameType {
    MENS_SINGLES(Format.SINGLES, GameGender.MALE),
    WOMENS_SINGLES(Format.SINGLES, GameGender.FEMALE),
    MENS_DOUBLES(Format.DOUBLES, GameGender.MALE),
    WOMENS_DOUBLES(Format.DOUBLES, GameGender.FEMALE),
    MIXED_DOUBLES(Format.DOUBLES, GameGender.MIXED);

    private final Format format;
    private final GameGender gender;

    GameType(Format format, GameGender gender) {
        this.format = format;
        this.gender = gender;
    }

    public GameGender getGameGender() {
        return gender;
    }

    public Format getFormat() {
        return format;
    }

    enum Format {
        SINGLES,
        DOUBLES
    }

    enum GameGender {
        MALE,
        FEMALE,
        MIXED
    }
}

package io.gametrack.competition.service;

/**
 * @author Kevin Sutton
 */
public class FixtureMatchCount {
    private final int mensSingles;
    private final int womensSingles;
    private final int mensDoubles;
    private final int womensDoubles;
    private final int mixedDoubles;

    private FixtureMatchCount(Builder builder) {
        this.mensSingles = builder.mensSingles;
        this.womensSingles = builder.womensSingles;
        this.mensDoubles = builder.mensDoubles;
        this.womensDoubles = builder.womensDoubles;
        this.mixedDoubles = builder.mixedDoubles;
    }

    public int getMensSingles() {
        return mensSingles;
    }

    public int getWomensSingles() {
        return womensSingles;
    }

    public int getMensDoubles() {
        return mensDoubles;
    }

    public int getWomensDoubles() {
        return womensDoubles;
    }

    public int getMixedDoubles() {
        return mixedDoubles;
    }

    public static class Builder {

        private int mensSingles = 0;
        private int womensSingles = 0;
        private int mensDoubles = 0;
        private int womensDoubles = 0;
        private int mixedDoubles = 0;

        public Builder mensSingles(int mensSingles) {
            this.mensSingles = mensSingles;
            return this;
        }
        public Builder womensSingles(int womensSingles) {
            this.womensSingles = womensSingles;
            return this;
        }
        public Builder mensDoubles(int mensDoubles) {
            this.mensDoubles = mensDoubles;
            return this;
        }
        public Builder womensDoubles(int womensDoubles) {
            this.womensDoubles = womensDoubles;
            return this;
        }
        public Builder mixedDoubles(int mixedDoubles) {
            this.mixedDoubles = mixedDoubles;
            return this;
        }

        public FixtureMatchCount build() {
            return new FixtureMatchCount(this);
        }

    }
}

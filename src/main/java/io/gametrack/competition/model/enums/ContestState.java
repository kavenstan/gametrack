package io.gametrack.competition.model.enums;

/**
 * @author Kevin Sutton
 */
public enum ContestState {
    CREATED(StateType.NOT_STARTED),
    SCHEDULED(StateType.NOT_STARTED),
    IN_PROGRESS(StateType.IN_PROGRESS),
    DRAWN(StateType.COMPLETE),
    WON(StateType.COMPLETE);

    private final StateType stateType;
    ContestState(StateType stateType) {
        this.stateType = stateType;
    }

    public StateType getStateType() {
        return stateType;
    }

    public enum StateType {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETE
    }
}

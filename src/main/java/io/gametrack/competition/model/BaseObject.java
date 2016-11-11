package io.gametrack.competition.model;

/**
 * @author Kevin Sutton
 */
public abstract class BaseObject {
    protected Long id;

    public abstract Long getId();

    public void setId(Long id) {
        this.id = id;
    }
}

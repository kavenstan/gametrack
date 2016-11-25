package io.gametrack2.score.model;

/**
 * @author Kevin Sutton
 */
public class ScoreSystem {

    private boolean drawAllowed;
    private boolean mustPlayAll;

    private int minPointsToWin;
    private int minWinMargin;
    private int maxPoints;

    private int pointsForWin;
    private int pointsForDraw;

    public boolean isDrawAllowed() {
        return drawAllowed;
    }

    public void setDrawAllowed(boolean drawAllowed) {
        this.drawAllowed = drawAllowed;
    }

    public boolean isMustPlayAll() {
        return mustPlayAll;
    }

    public void setMustPlayAll(boolean mustPlayAll) {
        this.mustPlayAll = mustPlayAll;
    }

    public int getMinPointsToWin() {
        return minPointsToWin;
    }

    public void setMinPointsToWin(int minPointsToWin) {
        this.minPointsToWin = minPointsToWin;
    }

    public int getMinWinMargin() {
        return minWinMargin;
    }

    public void setMinWinMargin(int minWinMargin) {
        this.minWinMargin = minWinMargin;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getPointsForWin() {
        return pointsForWin;
    }

    public void setPointsForWin(int pointsForWin) {
        this.pointsForWin = pointsForWin;
    }

    public int getPointsForDraw() {
        return pointsForDraw;
    }

    public void setPointsForDraw(int pointsForDraw) {
        this.pointsForDraw = pointsForDraw;
    }
}

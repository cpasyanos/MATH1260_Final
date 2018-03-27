package main;

public class Screen {
    private final Implicit rightWall;
    private final Implicit leftWall;
    private final Implicit topWall;
    private final Implicit bottomWall;

    public Screen(Implicit rightWall, Implicit leftWall, Implicit topWall, Implicit bottomWall) {
        this.rightWall = rightWall;
        this.leftWall = leftWall;
        this.topWall = topWall;
        this.bottomWall = bottomWall;
    }

    public Implicit getRightWall() {
        return rightWall;
    }

    public Implicit getLeftWall() {
        return leftWall;
    }

    public Implicit getTopWall() {
        return topWall;
    }

    public Implicit getBottomWall() {
        return bottomWall;
    }
}

package main.GameLogic;

import main.MathLogic.Position2D;

public class Paddle {
    private Position2D position;
    private double angle;

    public Paddle(Position2D position, double angle) {
        this.position = position;
        this.angle = angle;
    }

    public Position2D getPosition() {
        return position;
    }

    public double getAngle() {
        return angle;
    }

}

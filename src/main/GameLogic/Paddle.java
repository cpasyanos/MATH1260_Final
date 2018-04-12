package main.GameLogic;

import main.MathLogic.Position2D;

public class Paddle {
  private Position2D position;
  private double angle;
  private final int padelwidth;
  private final int padelheight;

  public Paddle(Position2D position, double angle) {
    this.position = position;
    this.angle = angle;
    padelwidth = 20;
    padelheight = 60;
  }

  public Position2D getPosition() {
    return position;
  }

  public double getAngle() {
    return angle;
  }

  /**
   * The paddle moves by adding to or subtracting it y position via mutation. Method is called
   * in the gameframe class via keylisteners.
   *
   * @param direction The direction to move the paddle in.
   */
  public void movePaddle (Direction direction) {
    if (direction == Direction.NORTH) {
      this.position.addToY(-30);
    } else if (direction == Direction.SOUTH) {
      this.position.addToY(30);
    }
  }

  public int getPadelWidth() {
    return padelwidth;
  }

  public int getPadelHeight() {
    return padelheight;
  }
}

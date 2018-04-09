package main.GameLogic;

public class Ball {


  private Line ballEqn;
  private int radius;

  /**
   * Every ball has a line representing where it is going and its starting point as well as its
   * radius.
   *
   * @param ballEqn   The line telling where the ball is going.
   * @param radius    The radius of the ball.
   */

  public Ball(Line ballEqn, int radius) {
    this.ballEqn = ballEqn;
    this.radius = radius;
  }

  public Line getBallEqn() {
    return ballEqn;
  }

  public int getRadius() {
    return radius;
  }
}


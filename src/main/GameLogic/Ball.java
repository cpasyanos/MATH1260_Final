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


  /**
   * MoveBall moves the ball by a percentage of the vector. So if percentageToMove is 1/10, then the
   * ball will also move 1/10 of whatever the vectar is.
   *
   * @param percentageToMove  How much of the distance vector should the ball move.
   */
  public void moveBall(float percentageToMove) {
    this.ballEqn.movementCalculation(percentageToMove);
  }
}


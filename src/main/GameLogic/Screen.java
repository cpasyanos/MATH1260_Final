package main.GameLogic;

import main.MathLogic.Position2D;

public class Screen {
  private final Line rightWall;
  private final Line leftWall;
  private final Line topWall;
  private final Line bottomWall;

  public Screen(Line rightWall, Line leftWall, Line topWall, Line bottomWall) {
    this.rightWall = rightWall;
    this.leftWall = leftWall;
    this.topWall = topWall;
    this.bottomWall = bottomWall;
  }

  public Line getRightWall() {
    return rightWall;
  }

  public Line getLeftWall() {
    return leftWall;
  }

  public Line getTopWall() {
    return topWall;
  }

  public Line getBottomWall() {
    return bottomWall;
  }

  //returns the line where the ball collided
  public Line wallCollision (Ball ball, double time) {
    Position2D ballP = ball.getBallEqn().getPoint();
    if (rightWall.isPointOfIntersection(ballP, time)) {
      return rightWall;
    } else if (leftWall.isPointOfIntersection(ballP, time)) {
      return leftWall;
    }  else if (topWall.isPointOfIntersection(ballP, time)) {
      return topWall;
    } else {
      return bottomWall;
    }
  }

}

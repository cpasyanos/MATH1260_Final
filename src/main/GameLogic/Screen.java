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



  public Line wallCollision (Ball ball, int width, int height) {
    Position2D ballP = ball.getBallEqn().getPoint();
    //System.out.println(ballP.toString());
    if (ballP.getX() < 30 && ballP.getY() < height) {
      System.out.println("leftwall");
      return leftWall;
    } else if (ballP.getX() < width && ballP.getX() > width - 30 && ballP.getY() < height) {
      return rightWall;
    } else if (ballP.getX() < width && ballP.getY() < height && ballP.getY() > height - 30) {
      return bottomWall;
    } else if (ballP.getX() < width && ballP.getY() > 0 && ballP.getY() < 30) {
      return topWall;
    } else return null;






//    if (rightWall.isPointOfIntersection(ballP)) {
//      System.out.println("rightwall");
//      return rightWall;
//    } else if (leftWall.isPointOfIntersection(ballP)) {
//      System.out.println("leftwall");
//      return leftWall;
//    } else if (topWall.isPointOfIntersection(ballP)) {
//      System.out.println("topwall");
//      return topWall;
//    } else if (bottomWall.isPointOfIntersection(ballP)){
//      System.out.println("bottomwall");
//      return bottomWall;
//    } else {
//      return null;
//    }
  }


}

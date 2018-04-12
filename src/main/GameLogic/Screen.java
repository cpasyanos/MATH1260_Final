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


  /**
   * Function determines whether the ball hit the edge of the screen. It does this by checking a
   * range 30 units out of the edge of the screen. Because of thread.sleep, collisions are inaccurate.
   * Atleast the way I did it here. There is no doubt a better way to do this.
   *
   * @param ball    The ball that needs to bounce around.
   * @param width   The width of the game world.
   * @param height  The height of the game world
   * @return        The equation of the wall a collision occured.
   */
  public Walls wallCollision (Ball ball, int width, int height) {
    Position2D ballP = ball.getBallEqn().getPoint();
    //System.out.println(ballP.toString());
    if (ballP.getX() < 30 && ballP.getY() < height) {
      return Walls.LEFT;
    } else if (ballP.getX() < width && ballP.getX() > width - 30 && ballP.getY() < height) {
      return Walls.RIGHT;
    } else if (ballP.getX() < width && ballP.getY() < height && ballP.getY() > height - 30) {
      return Walls.SOUTH;
    } else if (ballP.getX() < width && ballP.getY() > 0 && ballP.getY() < 30) {
      return Walls.NORTH;
    } else return null;
  }




}

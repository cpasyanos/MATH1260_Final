package main.GameLogic;

import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Line {

  private Vector vector;
  private Position2D point;

  /**
   * A line has a starting position and vector magnitude. This line is used to represent the walls
   * as well as the ball and paddle.
   *
   * @param vector The distance of the Line.
   * @param point  This is the starting point of the line.
   */

  public Line(Vector vector, Position2D point) {
    this.vector = vector;
    this.point = point;
  }

  public Vector getVector() {
    return vector;
  }

  public Position2D getPoint() {
    return point;
  }


  public boolean isPointOfIntersection (Position2D other, double time) {
    float x1 = this.point.getX() + (this.getVector().getDirection().getX() * (float)time);
    float x2 = other.getX();

    float y1 = this.point.getY() + (this.getVector().getDirection().getY() * (float)time);
    float y2 = other.getY();

    if (x1 == x2 && y1 == y2) {
      return true;
    } else {
      return false;
    }
  }


}

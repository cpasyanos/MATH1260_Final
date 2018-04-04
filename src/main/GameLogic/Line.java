package main.GameLogic;

import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Line {

  //length of wall?
  private Vector vector;

  //starting point of wall?
  private Position2D point;

  Line(Vector vector, Position2D point) {
    this.vector = vector;
    this.point = point;
  }

  public Vector getVector() {
    return vector;
  }

  public Position2D getPoint() {
    return point;
  }

  //function tells whether there is a point of intersection
  public boolean isPointOfIntersection (Position2D other, int time) {
    float x1 = this.point.getX() + (this.getVector().getDirection().getX() * time);
    float x2 = other.getX();

    float y1 = this.point.getY() + (this.getVector().getDirection().getY() * time);
    float y2 = other.getY();

    if (x1 == x2 && y1 == y2) {
      return true;
    } else {
      return false;
    }
  }


}

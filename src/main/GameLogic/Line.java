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


  /**
   * Code determines whether the two vectors are equal to eachother.
   *
   * @param ballPoint The current position of the ball.
   * @return Whether or not ball collided with something.
   */
  public boolean isPointOfIntersection(Position2D ballPoint) {
    float x1 = this.point.getX() + (this.getVector().getDirection().getX());
    float x2 = ballPoint.getX();

    float y1 = this.point.getY() + (this.getVector().getDirection().getY());
    float y2 = ballPoint.getY();

    float impX = this.vector.getDirection().getX();
    float impY = -this.vector.getDirection().getY();
    Vector impVector = new Vector(1, new Position2D(impX, impY));
    float constant = (impVector.getDirection().getX() * point.getX()) + (impVector.getDirection().getY() * point.getY());

    return ((x2 * impX) + (y2 * impY)) == constant;
  }


  /**
   * Moves the ball by a certain percentage of its total vector distance.
   *
   * @param percentageToMove The amount to move the ball.
   */
  public void movementCalculation(float percentageToMove) {
    Vector toMove = this.vector.applyScalar(percentageToMove);
    this.point = this.point.add(toMove.getDirection());
  }

  @Override
  public String toString() {
    return this.point.toString() + " and the " + this.vector.toString();
  }
}

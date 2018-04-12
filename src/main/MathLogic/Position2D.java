package main.MathLogic;

import java.util.Objects;

public class Position2D {
  private float x;
  private float y;

  public Position2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  /**
   * Adds together two positions.
   *
   * @param that The other position to add.
   * @return The new position.
   */
  public Position2D add(Position2D that) {
    return new Position2D(this.x + that.x, this.y + that.y);
  }

  /**
   * Point of intersection uses this in other to determine if two points are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Position2D) {
      return ((Position2D) other).x == this.x &&
              ((Position2D) other).y == this.y;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return "Position is " + "(" + this.x + ", " + this.y + ")";
  }
}

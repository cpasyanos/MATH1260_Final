package main;

import java.util.Objects;

public class Vector {
  private int magnitude;
  private Position2D direction;

  Vector(int magnitude, Position2D direction) {
    this.magnitude = magnitude;
    this.direction = direction;
  }

  public int getMagnitude() {
    return magnitude;
  }

  public Position2D getDirection() {
    return direction;
  }

  //computes the dot product of this and the given vector
  public float dotProduct(Vector other) {
    return (this.direction.getX() * other.direction.getX()) + (this.direction.getY() * other.direction.getY());
  }

  // applies the given to scalar to each component of this vector
  public Vector applyScalar(float scalar) {
    return new Vector(this.getMagnitude(), new Position2D(scalar * this.getDirection().getX(), scalar * this.getDirection().getY()));
  }


  @Override
  public boolean equals(Object other) {
    if (other instanceof Vector) {
      return this.getMagnitude() == ((Vector) other).getMagnitude()
              && this.getDirection().getX() == ((Vector) other).getDirection().getX()
              && this.getDirection().getY() == ((Vector) other).getDirection().getY();
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.magnitude, this.direction);
  }
}

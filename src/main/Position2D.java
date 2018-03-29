package main;

public class Position2D {
  private float x;
  private float y;

  Position2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  //adds together two positions
  public Position2D add(Position2D that) {
    return new Position2D(this.x + that.x, this.y + that.y);
  }
}

package main.MathLogic;

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
   * @param that  The other position to add.
   * @return      The new position.
   */
  public Position2D add(Position2D that) {
    return new Position2D(this.x + that.x, this.y + that.y);
  }
}

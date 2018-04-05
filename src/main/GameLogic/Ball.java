package main.GameLogic;

import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Ball {
  private Vector vector;
  private Position2D position;
  private int radius;

  public Ball(Vector vector, Position2D position, int radius) {
    this.vector = vector;
    this.position = position;
    this.radius = radius;
  }

  public Vector getVector() {
    return vector;
  }

  public Position2D getPosition() {
    return position;
  }

  //Changes the position over time
  //Confused about what to do over the magnitude

  /**
   * Basically, Im just adding to vectors together over and over.
   */
  public void move (float time) {
    position.add(vector.getDirection());
  }


  public int getRadius() {
    return radius;
  }
}


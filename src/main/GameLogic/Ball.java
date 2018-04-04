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
  public void move () {
    position.add(vector.getDirection());

    //HAVE TO ALSO HANDLE COLLISIONS WITH THE WALL
    //WALLS ARE MADE WITH IMPLICIT EQNS THOUGH


  }

}


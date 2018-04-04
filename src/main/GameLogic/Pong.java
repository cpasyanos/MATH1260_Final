package main.GameLogic;

import main.GUI.GameFrame;
import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Pong implements IPong {
  private Ball ball;
  private Paddle paddle;
  private Paddle paddle2;
  private Screen screen;
  private GameFrame gFrame;
  private static final int width = 1200;
  private static final int height = 1000;

  public Pong(Ball ball, Paddle paddle, Paddle paddle2, Screen screen) {
    this.ball = ball;
    this.paddle = paddle;
    this.paddle2 = paddle2;
    this.screen = screen;
    this.gFrame = new GameFrame(width, height);
  }

  public Ball getBall() {
    return ball;
  }

  public Paddle getPaddle() {
    return paddle;
  }

  public Paddle getPaddle2() {
    return paddle2;
  }

  //game loop
  @Override
  public void play() {
    gFrame.setVisible(true);
  }

  //A collision between the ball and the wall
  //when there is a collision, reflect the ball
  private void wallCollision(int time) {
    Line wallEquation = this.screen.wallCollision(ball, time);
    reflectedVector(ball, wallEquation);
  }

  //returns the reflected vector of the given ball onto the given line
  @Override
  public Vector reflectedVector(Ball ball, Line wallEquation) {
    float ballX = ball.getVector().getDirection().getX();
    float ballY = ball.getVector().getDirection().getY();
    Vector ballVector = new Vector(ball.getVector().getMagnitude(), new Position2D(ballX, ballY));

    float impX = wallEquation.getVector().getDirection().getY();
    float impY = -wallEquation.getVector().getDirection().getX();
    Vector impVector = new Vector(1, new Position2D(impX, impY));

    float scalar = ballVector.dotProduct(impVector) / impVector.dotProduct(impVector);

    Vector projVector = impVector.applyScalar(scalar);

    Vector twoTimes = projVector.applyScalar(2);

    Vector finalVector = new Vector(ball.getVector().getMagnitude(),
            new Position2D(ballX - twoTimes.getDirection().getX(), ballY - twoTimes.getDirection().getY()));
    return finalVector;
  }
}
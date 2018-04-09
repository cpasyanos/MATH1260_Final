package main.GameLogic;

import java.awt.*;

import main.GUI.GameFrame;
import main.GUI.GameView;
import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Pong implements IPong {
  private Ball ball;
  private Paddle paddle;
  private Paddle paddle2;
  private Screen screen;
  private GameFrame gFrame;
  private GameView view;
  private final int width;
  private final int height;
  //this is going to be reset throughout the game. Specifically after every collision.
  private long startTime = System.currentTimeMillis()/1000;


  public Pong(Ball ball, Paddle paddle, Paddle paddle2, Screen screen, int width, int height) {
    this.ball = ball;
    this.paddle = paddle;
    this.paddle2 = paddle2;
    this.screen = screen;
    this.width = width;
    this.height = height;
    this.gFrame = new GameFrame(width, height);
    view = new GameView(width, height, ball);
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
    boolean gameLoop = true;
    view.setPreferredSize(new Dimension(width, height));
    this.gFrame.setContentPane(view);
    this.gFrame.pack();

    //keep this loop running till the game ends
    while (gameLoop) {
      //elapsed time is basically the timer of the game.
      long elapsedTime = System.currentTimeMillis()/1000 - startTime;
      try {
        // thread to sleep for 1000 milliseconds
        // this is basically the refresh rate for the game
        Thread.sleep(100);
        System.out.println(elapsedTime);
        ball.moveBall((float)0.1);
        view.repaint();
      } catch (Exception e) {
        System.out.println(e);
      }

    }
  }

  //A collision between the ball and the wall
  //when there is a collision, reflect the ball
  private void wallCollision(double time) {
    Line wallEquation = this.screen.wallCollision(ball, time);
    reflectedVector(ball, wallEquation);
  }

  //returns the reflected vector of the given ball onto the given line
  @Override
  public Vector reflectedVector(Ball ball, Line wallEquation) {
    float ballX = ball.getBallEqn().getVector().getDirection().getX();
    float ballY = ball.getBallEqn().getVector().getDirection().getY();
    Vector ballVector = new Vector(ball.getBallEqn().getVector().getMagnitude(), new Position2D(ballX, ballY));

    float impX = wallEquation.getVector().getDirection().getY();
    float impY = -wallEquation.getVector().getDirection().getX();
    Vector impVector = new Vector(1, new Position2D(impX, impY));

    float scalar = ballVector.dotProduct(impVector) / impVector.dotProduct(impVector);

    Vector projVector = impVector.applyScalar(scalar);

    Vector twoTimes = projVector.applyScalar(2);

    Vector finalVector = new Vector(ball.getBallEqn().getVector().getMagnitude(),
            new Position2D(ballX - twoTimes.getDirection().getX(), ballY - twoTimes.getDirection().getY()));
    return finalVector;
  }
}

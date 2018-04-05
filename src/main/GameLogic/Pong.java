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

    long lastLoopTime = System.nanoTime();
    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    double lastFpsTime = 0;
    double fps = 0;

    //keep this loop running till the game ends
    while (gameLoop) {

      //work out how long its been since the last update, this will be used to calculate how far
      // the entities should move this loop
      long now = System.nanoTime();
      long updateLength = now - lastLoopTime;
      lastLoopTime = now;
      double delta = updateLength/ (double) OPTIMAL_TIME;

      //update the frame counter
      lastFpsTime += updateLength;
      fps++;

      // update our FPS counter if a second has passed since
      // we last recorded
      if (lastFpsTime >= 1000000000)
      {
        System.out.println("(FPS: "+fps+")");
        lastFpsTime = 0;
        fps = 0;
      }

      System.out.println(delta);
      // update the game logic
      wallCollision(delta);

      // draw everyting
      view.repaint();



      // we want each frame to take 10 milliseconds, to do this
      // we've recorded when we started the frame. We add 10 milliseconds
      // to this and then factor in the current time to give
      // us our final value to wait for
      // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.

        try{
          Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
        } catch (Exception e) {
          System.out.println(e.toString() + "try catch in play");
        }




      view.repaint();
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

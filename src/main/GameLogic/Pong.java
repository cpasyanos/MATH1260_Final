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
  private int playerOneScore;
  private int playerTwoScore;



  public Pong(Ball ball, Paddle paddle, Paddle paddle2, Screen screen, int width, int height, int playerOneScore, int playerTwoScore) {
    this.ball = ball;
    this.paddle = paddle;
    this.paddle2 = paddle2;
    this.screen = screen;
    this.width = width;
    this.height = height;
    this.playerOneScore = playerOneScore;
    this.playerTwoScore = playerTwoScore;
    this.gFrame = new GameFrame(width, height, this);
    view = new GameView(width, height, ball, paddle, paddle2);

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
      //System.out.println(elapsedTime);
      try {
        // thread to sleep for 1000 milliseconds
        // this is basically the refresh rate for the game
        Thread.sleep(30);
        ball.moveBall((float)0.1);
        this.wallCollision();
        this.paddleCollision();
        view.repaint();
      } catch (Exception e) {
        System.out.println(e);
      }

    }
  }

  //A collision between the ball and the wall
  //when there is a collision, reflect the ball
  private void wallCollision() {
    Walls wall = this.screen.wallCollision(ball, width, height);
    if (wall == Walls.LEFT) {
      playerOneScore++;
      reset();
    } else if (wall == Walls.RIGHT) {
      playerTwoScore++;
      reset();
    } else if (wall == Walls.NORTH) {
      reflectedLine(ball, screen.getTopWall());
    } else if (wall == Walls.SOUTH) {
      reflectedLine(ball, screen.getBottomWall());
    } else {

    }
  }

  /**
   * Function returns the balls new reflected vector. It uses the vector equation we learned in
   * class.
   *
   * @param ball          The ball that went through the collision.
   * @param wallEquation  The equation that the ball collided with.
   * @return              The new Ball Equation.
   */
  private Line reflectedLine(Ball ball, Line wallEquation) {
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
    return new Line(finalVector,ball.getBallEqn().getPoint());
  }

  @Override
  public Paddle getLeftPaddle() {
    return this.paddle;
  }

  @Override
  public Paddle getRightPaddle() {
    return this.paddle2;
  }

  /**
   * I am only working on paddle collision for the left and right side of the paddle.
   */
  private void paddleCollision () {
    if (ball.getBallEqn().getPoint().getX() > paddle.getPosition().getX() + paddle.getPadelWidth()/2
            && ball.getBallEqn().getPoint().getX() < paddle.getPosition().getX() + paddle.getPadelWidth()/2 + 30
            && ball.getBallEqn().getPoint().getY() < paddle.getPosition().getY() + paddle.getPadelHeight()/2
            && ball.getBallEqn().getPoint().getY() > paddle.getPosition().getY() - paddle.getPadelHeight()/2) {
      ball.setBallEqn(reflectedLine(this.ball, new Line(new Vector (1, new Position2D(0, 1)), paddle.getPosition())));
    }


    if (ball.getBallEqn().getPoint().getX() < paddle2.getPosition().getX() - paddle.getPadelWidth()/2
            && ball.getBallEqn().getPoint().getX() > paddle2.getPosition().getX() - paddle.getPadelWidth()/2 - 30
            && ball.getBallEqn().getPoint().getY() < paddle2.getPosition().getY() + paddle.getPadelHeight()/2
            && ball.getBallEqn().getPoint().getY() > paddle2.getPosition().getY() - paddle.getPadelHeight()/2) {
      ball.setBallEqn(reflectedLine(this.ball, new Line(new Vector (1, new Position2D(0, 1)), paddle2.getPosition())));
    }

  }

  private void reset () {
    Vector temp = new Vector(1, new Position2D(-70, -50));
    ball.setBallEqn(new Line (temp,  new Position2D(width/2, height/2)));
    ball.setRadius(10);
  }

  @Override
  public int getPlayerOneScore() {
    return this.playerOneScore;
  }

  @Override
  public int getPlayerTwoScore() {
    return this.playerTwoScore;
  }
}

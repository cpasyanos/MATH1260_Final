package main;


import main.GameLogic.*;
import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Main {

  private static final int width = 800;
  private static final int height = 800;

  public static void main(String[] args) {

    //walls here
    Vector rightAndLeftWallVectar = new Vector(1, new Position2D(0, height));
    Vector topAndBottomWallVectar = new Vector(1, new Position2D(width, 0));
    Line rightWall = new Line(rightAndLeftWallVectar, new Position2D(width,0 ));
    Line leftWall = new Line(rightAndLeftWallVectar, new Position2D(0,0 ));
    Line topWall = new Line (topAndBottomWallVectar, new Position2D(0,0 ));
    Line bottomWall = new Line (topAndBottomWallVectar, new Position2D(0, height));
    Screen screen = new Screen(rightWall, leftWall, topWall, bottomWall);

    //ball stuff
    Vector ballVector = new Vector(1, new Position2D(-70, -50));
    Ball ball = new Ball(new Line (ballVector, new Position2D(width/2, height/2)), 10);

    //paddle stuff here
    Position2D leftP = new Position2D(width/2 - width/4, height/2);
    Position2D rightP = new Position2D(width/2 + width/4, height/2);
    Paddle paddle1 = new Paddle(leftP, 90);
    Paddle paddle2 = new Paddle(rightP, 90);

    //score stuff here
    int score1 = 0;
    int score2 = 0;

    IPong pong = new Pong(ball, paddle1, paddle2, screen, width, height, score1, score2);
    pong.play();
  }
}


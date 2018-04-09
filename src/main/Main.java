package main;


import java.time.Duration;

import main.GameLogic.*;
import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Main {

  private static final int width = 800;
  private static final int height = 800;

  public static void main(String[] args) {

    //walls here
    Vector rightAndLeftWallVectar = new Vector(1, new Position2D(0, -height));
    Vector topAndBottomWallVectar = new Vector(1, new Position2D(width, 0));
    Line rightWall = new Line(rightAndLeftWallVectar, new Position2D(width,0 ));
    Line leftWall = new Line(rightAndLeftWallVectar, new Position2D(0,0 ));
    Line topWall = new Line (topAndBottomWallVectar, new Position2D(0,0 ));
    Line bottomWall = new Line (topAndBottomWallVectar, new Position2D(0,-height));
    Screen screen = new Screen(rightWall, leftWall, topWall, bottomWall);



    //ball stuff
    Vector ballVector = new Vector(1, new Position2D(50, 50));
    Ball ball = new Ball(new Line (ballVector, new Position2D(width/2, height/2)), 10);


    //paddle stuff here
    Position2D origin = new Position2D(0, 0);
    Paddle paddle1 = new Paddle(origin, 90);
    Paddle paddle2 = new Paddle(origin, 90);



    IPong pong = new Pong(ball, paddle1, paddle2, screen, width, height);

    pong.play();
  }
}


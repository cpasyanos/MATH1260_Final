package main;


import java.time.Duration;

import main.GameLogic.*;
import main.MathLogic.Position2D;
import main.MathLogic.Vector;

public class Main {

  private static final int width = 800;
  private static final int height = 800;

  public static void main(String[] args) {




    Vector testVector = new Vector(1, new Position2D(3, -4));
    Vector complexReflection = new Vector(1, new Position2D(1, 2));
    Ball ball = new Ball(testVector, new Position2D(width/2, height/2), 10);
    Position2D origin = new Position2D(0, 0);
    Paddle paddle1 = new Paddle(origin, 90);
    Paddle paddle2 = new Paddle(origin, 90);
    Line complexLine = new Line(complexReflection, new Position2D(0, 0));
    Line testLine = new Line(new Vector(1, new Position2D(5, 0)), new Position2D(0, 0));
    Screen screen = new Screen(complexLine, testLine, testLine, testLine);
    IPong pong = new Pong(ball, paddle1, paddle2, screen, width, height);

    pong.play();
  }
}


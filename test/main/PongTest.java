package main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PongTest {
  Vector testVector = new Vector (1,new Position2D(3, -4));
  Ball ball = new Ball (testVector, new Position2D(0,0), 5);
  Position2D origin = new Position2D(0, 0);
  Paddle paddle1 = new Paddle(origin, 90);
  Paddle paddle2 = new Paddle(origin, 90);
  Implicit testImplicit = new Implicit(new Vector(1, new Position2D(5, 0)), new Position2D(0,0));
  Screen screen = new Screen(testImplicit, testImplicit, testImplicit, testImplicit);
  IPong pong = new Pong(ball, paddle1, paddle2, screen);

  @Test
  public void testReflection () {
    assertEquals(new Vector(1, new Position2D(3,4)),
            pong.reflectedVector(this.ball, this.screen.getTopWall()));
  }


}
package main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PongTest {
  Vector testVector = new Vector (1,new Position2D(3, -4));
  Vector complexReflection = new Vector(1, new Position2D(1,2));
  Ball ball = new Ball (testVector, new Position2D(0,0), 5);
  Position2D origin = new Position2D(0, 0);
  Paddle paddle1 = new Paddle(origin, 90);
  Paddle paddle2 = new Paddle(origin, 90);
  Line complexLine = new Line(complexReflection, new Position2D(0,0));
  Line testLine = new Line(new Vector(1, new Position2D(5, 0)), new Position2D(0,0));
  Screen screen = new Screen(complexLine, testLine, testLine, testLine);
  IPong pong = new Pong(ball, paddle1, paddle2, screen);

  @Test
  public void testReflection () {
    assertEquals(3,
            pong.reflectedVector(this.ball, this.screen.getTopWall()).getDirection().getX(), .5);
    assertEquals(4,
            pong.reflectedVector(this.ball, this.screen.getTopWall()).getDirection().getY(), .5);
    assertEquals(new Vector(1, new Position2D(3, 4)), pong.reflectedVector(this.ball, this.screen.getTopWall()));
    assertEquals(new Vector(1, new Position2D(-5, 0)), pong.reflectedVector(this.ball, this.screen.getRightWall()));
  }

  @Test
  public void testDotProduct () {
    assertEquals(15.0,
            ball.getVector().dotProduct(screen.getTopWall().getVector()), .5);
  }

  @Test
  public  void testApplyVector() {
    assertEquals(new Vector(1, new Position2D(10, 0)), testLine.getVector().applyScalar(2));
  }


}
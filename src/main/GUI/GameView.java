package main.GUI;

import java.awt.*;

import javax.swing.*;

import main.GameLogic.Ball;

public class GameView extends JPanel {

  private final int width;
  private final int height;
  Ball b;



  public GameView(int width, int height, Ball b) {
    this.width = width;
    this.height = height;
    this.b = b;
  }

  @Override
  public void paint (Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.BLUE);
    g.fillOval((int)b.getBallEqn().getPoint().getX(), (int)b.getBallEqn().getPoint().getY(),
            b.getRadius() * 2, b.getRadius() * 2);
  }
}

package main.GUI;

import java.awt.*;

import javax.swing.*;

import main.GameLogic.Ball;
import main.GameLogic.Paddle;

public class GameView extends JPanel {

  private final int vwidth;
  private final int vheight;
  Ball b;
  Paddle leftP;
  Paddle rightP;
  private int score1, score2;

  public GameView(int width, int height, Ball b, Paddle leftP, Paddle rightP) {
    this.vwidth = width;
    this.vheight = height;
    this.b = b;
    this.leftP = leftP;
    this.rightP = rightP;
    score1 = 0;
    score2 = 0;
  }

  @Override
  public void paint (Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, vwidth, vheight);
    g.setColor(Color.BLUE);
    g.fillOval((int)b.getBallEqn().getPoint().getX(), (int)b.getBallEqn().getPoint().getY(),
            b.getRadius() * 2, b.getRadius() * 2);
    g.fillRect((int) leftP.getPosition().getX(), (int) leftP.getPosition().getY(), leftP.getPadelWidth(), leftP.getPadelHeight());
    g.fillRect((int) rightP.getPosition().getX(), (int) rightP.getPosition().getY(), rightP.getPadelWidth(), rightP.getPadelHeight());
    g.setFont(new Font("idk", Font.BOLD, 24));
    g.setColor(Color.WHITE);
    g.drawString("p1: " + score1, vwidth / 4 - 20, 50);
    g.drawString("p2: " + score2, 3*vwidth / 4, 50);
  }

  public void updateScore(int score1, int score2) {
    this.score1 = score1;
    this.score2 = score2;
  }
}

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


  public GameView(int width, int height, Ball b, Paddle leftP, Paddle rightP) {
    this.vwidth = width;
    this.vheight = height;
    this.b = b;
    this.leftP = leftP;
    this.rightP = rightP;
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
    g.drawString("pong!!!", vwidth / 2, 50);

  }
}

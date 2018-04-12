package main.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import main.GameLogic.Direction;
import main.GameLogic.IPong;

public class GameFrame extends JFrame implements KeyListener {

  private IPong pong;
  private JLabel playerOne;
  private JLabel playerTwo;
  private JTextArea area;
  private JPanel panel;

  public GameFrame(int width, int height, IPong pong) {
    setTitle("Pong II: Electric Boogaloo");
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pong = pong;
    this.addKeyListener(this);
    panel = new JPanel();
    /* playerOne = new JLabel(Integer.toString(pong.getPlayerOneScore()));
    playerTwo = new JLabel(Integer.toString(pong.getPlayerTwoScore()));
    add(playerOne);
    add(playerTwo);
    area = new JTextArea();
    panel.add(playerOne);
    panel.add(playerTwo);
    add (panel, BorderLayout.NORTH);
    add(area, BorderLayout.CENTER);*/
    setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //not going to use
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();


    if (keyCode == KeyEvent.VK_W) {
      pong.getLeftPaddle().movePaddle(Direction.NORTH);
    }

    if (keyCode == KeyEvent.VK_S) {
      pong.getLeftPaddle().movePaddle(Direction.SOUTH);
    }

    if (keyCode == KeyEvent.VK_UP) {
      pong.getRightPaddle().movePaddle(Direction.NORTH);
    }

    if (keyCode == KeyEvent.VK_DOWN) {
      pong.getRightPaddle().movePaddle(Direction.SOUTH);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //do not need
  }
}

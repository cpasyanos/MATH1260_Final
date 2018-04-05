package main.GUI;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

  public GameFrame(int width, int height) {
    setTitle("Pong II: Electric Boogaloo");
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

}

package main.GameLogic;

import main.MathLogic.Vector;

public interface IPong {

  void play();

  Vector reflectedVector(Ball ball, Line wallEquation);
}

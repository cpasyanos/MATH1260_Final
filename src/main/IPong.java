package main;

public interface IPong {

  void play();

  Vector reflectedVector(Ball ball, Implicit wallEquation);
}

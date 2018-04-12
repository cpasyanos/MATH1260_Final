package main.GameLogic;

public interface IPong {

  void play();

  Paddle getLeftPaddle ();

  Paddle getRightPaddle ();

  int getPlayerOneScore ();

  int getPlayerTwoScore();


}

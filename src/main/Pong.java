package main;

public class Pong implements IPong{
    private Ball ball;
    private Paddle paddle;
    private Paddle paddle2;

    public Pong(Ball ball, Paddle paddle, Paddle paddle2) {
        this.ball = ball;
        this.paddle = paddle;
        this.paddle2 = paddle2;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    //game loop
    public void play() {
    }
}

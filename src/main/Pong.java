package main;

public class Pong implements IPong{
    private Ball ball;
    private Paddle paddle;
    private Paddle paddle2;
    private Screen screen;

    public Pong(Ball ball, Paddle paddle, Paddle paddle2, Screen screen) {
        this.ball = ball;
        this.paddle = paddle;
        this.paddle2 = paddle2;
        this.screen = screen;
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

    //A collision between the ball and the wall
    private void wallCollision () {
         this.ball.getVector();
    }

    public Vector reflectedVector(Ball ball, Implicit wallEquation) {
        Vector normalVector = new Vector(1, new Position2D(wallEquation.getVector().getDirection().getY(),
                -1 *wallEquation.getVector().getDirection().getX()));
        int scalar = (ball.getVector().dotProduct(wallEquation.getVector())) / (wallEquation.getVector().dotProduct(wallEquation.getVector()));
        Vector projVector = new Vector(1, new Position2D((scalar * normalVector.getDirection().getX()),
                (scalar * normalVector.getDirection().getY())));
        Vector twoTimes = new Vector(1, new Position2D((2 * projVector.getDirection().getX()), (2 * projVector.getDirection().getY())));

        Vector finalVector = new Vector(ball.getVector().getMagnitude(), new Position2D(ball.getVector().getDirection().getX() - twoTimes.getDirection().getX(),
                ball.getVector().getDirection().getY() - twoTimes.getDirection().getY()));
        return finalVector;
    }
}

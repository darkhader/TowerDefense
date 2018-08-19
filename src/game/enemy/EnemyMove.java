package game.enemy;

import base.GameObject;
import base.Vector2D;

import java.util.List;

public class EnemyMove {
    // Instance variables

    //public static int ballX, ballY;
    private int index;
    private List<Coordinate> path;
    public Vector2D position;
    public Vector2D velocity;
    int startX, startY, endX, endY, dX, dY;

    public EnemyMove(List<Coordinate> points) {    // Initializes variables

        this.index = 0;
        this.path = points;
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.velocity.set(0,0);
    }

    public boolean isAtTheEndOfPath() {

        return (Math.abs(endX - this.position.x) <= 3 && Math.abs(endY - this.position.y) <= 3);

    }

    public boolean isAtTheEnd() {

        return index == path.size() - 1;

    }

    public void getPath() {
        startX = (int) path.get(index).x;
        endX = (int) path.get(index + 1).x;

        startY = (int) path.get(index).y;
        endY = (int) path.get(index + 1).y;

        dX = endX - startX;
        dY = endY - startY;

        index++;
    }

//    private void rotateVelocity() {
//        if (dX == 0) {
//            angle = 90;
//        }
//        if (dY == 0) {
//            angle = -90;
//        } else {
//            angle = Math.toDegrees(Math.tan(dY / dX));
//        }
//
//        this.velocity.rotate(angle);
//    }

    public void getVelocity() {
        this.velocity.x = dX / 15;
        this.velocity.y = dY / 15;
    }

    public void move() {
        this.position.addUp(this.velocity);

    }

    public void reset() {
        this.index = 0;
    }

    public void run() {
        this.getPath();
        while (!this.isAtTheEnd()) {
            if (!this.isAtTheEndOfPath()) {
                this.move();
            } else {
                this.getPath();
                this.getVelocity();
            }
        }
        this.reset();
    }

}

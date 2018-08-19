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
        //kiểm tra nếu đã đến cuối Path hiện tại chưa
        return (Math.abs(endX - this.position.x) <= 3 && Math.abs(endY - this.position.y) <= 3);

    }

    public boolean isAtTheEnd() {
        //kiểm tra nếu đã đến hết đường
        return index == path.size() - 1;

    }

    public void getPath() {
        //lấy ra startX, endX
        startX = path.get(index).x;
        endX = path.get(index + 1).x;
        //lấy ra startY, endY
        startY = path.get(index).y;
        endY = path.get(index + 1).y;
        //lấy khoảng cách X,Y
        dX = endX - startX;
        dY = endY - startY;
        //cho index tăng lên 1
        index++;
    }

    public void getVelocity() {
        //xác định velocity
        //ví dụ path bắt đầu từ 0,300 đến 300,300 thì velocity sẽ là (20, 0)
        this.velocity.x = dX / 15;
        this.velocity.y = dY / 15;
    }

    public void move() {
        //cho chạy
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

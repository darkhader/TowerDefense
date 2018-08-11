public class BulletTower1 {

    public Vector2D position;

    public Vector2D velocity;

    public BulletTower1() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

}

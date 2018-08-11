public class Enemy {

    public Vector2D position;
    public Vector2D velocity;

    public Renderer renderer;

    public Enemy() {
        this.position = new Vector2D();
        this.renderer = new ImageRenderer("resources/Alien-Ship.png", 30, 30);
        this.velocity = new Vector2D();
    }







}

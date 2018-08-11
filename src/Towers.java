import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Towers {

    public Vector2D position;

    public Renderer renderer;

    public List<TowerAttribute> attributes;

    public Towers() {
        this.position = new Vector2D();
        this.position.set(300,200);
        this.attributes = new ArrayList<>();
    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }






}

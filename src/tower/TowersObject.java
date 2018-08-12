package tower;

import base.Vector2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import renderer.Renderer;

public class TowersObject {

    public Vector2D position;

    public Renderer renderer;
    public boolean isAlive = true;
    public List<TowerAttribute> attributes;

    public TowersObject() {
        this.position = new Vector2D();

        this.attributes = new ArrayList<>();
    }

    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }

}

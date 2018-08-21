package base;

import action.Action;
import java.awt.Graphics;
import java.util.ArrayList;
import renderer.Renderer;

import java.util.List;
import java.util.Random;


public class GameObject {

    public Vector2D position;

    public Renderer renderer;

    public List<Attribute> attributes;

    public boolean isAlive = true;
    public boolean inAction = false;
    public List<Action> actions;
      public Random random = new Random();

    public GameObject() {
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
        this.actions = new ArrayList<>();
    }

    public void run() {
        this.attributes
                .forEach(attribute -> attribute.run(this));
        actions.removeIf(action -> action.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer != null)
            this.renderer.render(graphics, this.position);
    }
    public void addAction(Action action){
        this.actions.add(action);
    }
}


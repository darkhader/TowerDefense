package base;

import java.awt.Graphics;
import java.util.ArrayList;

import action.Action;
import renderer.Renderer;

import java.util.List;


public class GameObject {
    
    public Vector2D position;
    public boolean isAlive = true;
    public Renderer renderer;
    public List<Attribute> attributes=new ArrayList<>();
    public List<Action> actions;
 
    
    public GameObject() {
        this.position = new Vector2D();
        this.actions = new ArrayList<>();
    }
    
    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
        //this.actions.removeIf(action -> action.run(this));
    }
    
    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }


}

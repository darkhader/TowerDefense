/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import base.Attribute;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Player extends GameObject {

    public Vector2D velocity;

    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("src\\resources\\images\\circle.png", 20, 20);

        this.attributes.add((Attribute) new PlayerMove());
        this.attributes.add((Attribute) new PlayerBuild());

    }

    @Override
    public void run() {
        super.run();

    }
}

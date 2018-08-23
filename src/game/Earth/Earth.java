/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Earth;

import base.GameObjManager;
import base.GameObject;
import game.enemy.Alien;
import game.enemy.Meteor;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Earth extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObject1;

    public Earth() {
        
        this.renderer = new ImageRenderer("src\\resources\\images\\worldwide.png", 150, 150);
        this.boxCollider = new BoxCollider(150, 150);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObject1 = new RunHitObject(Meteor.class);
    }

    public void run() {
        super.run();     
        this.boxCollider.position.set(this.position.x - 75, this.position.y - 75);
        this.runHitObject.run(this);
        this.runHitObject1.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = true;
        gameObject.isAlive=false;
    }

    @Override
    public void getInsight(GameObject gameObject) {

    }

}

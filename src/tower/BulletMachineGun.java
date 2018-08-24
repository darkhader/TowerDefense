/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
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
public class BulletMachineGun extends GameObject implements PhysicBody {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObjectMeteor;
    private FrameCounter frameCounter;

    public BulletMachineGun() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.frameCounter = new FrameCounter(10);
        this.damage = 1;

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);
        this.runHitObject.run(this);
        this.runHitObjectMeteor.run(this);
        this.velocity.set(0, 0);
        Alien alien = GameObjManager.instance.findAlien();
        Meteor meteor = GameObjManager.instance.findMeteor();
        if (alien != null&& meteor == null) {
            this.update(alien.position);
       }
        
        if (meteor != null && alien == null) {
            this.update(meteor.position);
       }
       if (alien != null && meteor != null) {
            this.update(meteor.position);
        }
       if (frameCounter.run()) {
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    private void update(Vector2D position) {
        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(10.5f);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }

    @Override
    public void getInsight(GameObject gameObject) {

    }
}

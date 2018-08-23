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
public class BulletTinker extends GameObject implements PhysicBody {

    private int count = 5;
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private RunHitObject runHitObject1;
    private FrameCounter frameCounter;

    public BulletTinker() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("src\\resources\\images\\fire.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
        this.runHitObject = new RunHitObject(Alien.class);
        this.runHitObject1 = new RunHitObject(Meteor.class);
        this.frameCounter = new FrameCounter(50);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);
        this.runHitObject.run(this);
        this.runHitObject1.run(this);
        this.velocity.set(0, 0);

        Alien alien = GameObjManager.instance.findAlien2();
        Meteor meteor = GameObjManager.instance.findMeteor2();
        if (alien != null && meteor == null) {
            this.updateVelo();
        }

        if (meteor != null && alien == null) {
            this.updateVelo();
        }
        if (alien != null && meteor != null) {
            this.updateVelo();
        }
        if (frameCounter.run()) {
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    public void updateVelo() {
        
        this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        if (count == 4) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 3) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 2) {
            this.velocity.set(random.nextInt(3) - 3, random.nextInt(3) - 1);
        }
        if (count == 1) {
            this.velocity.set(random.nextInt(3)- 3, random.nextInt(3) - 1);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        count--;
        if (count == 0) {
            this.isAlive = false;
        }

    }

    @Override
    public void getInsight(GameObject gameObject) {

    }
}

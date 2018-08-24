/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Earth;

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
    private RunHitObject runHitObjectAlien;
    private RunHitObject runHitObjectMeteor;
    public int enemyDiedOnEarth = 0;

    public Earth() {
        
        this.renderer = new ImageRenderer("resources/images/worldwide.png", 150, 150);
        this.boxCollider = new BoxCollider(150, 150);
        this.runHitObjectAlien = new RunHitObject(Alien.class);
        this.runHitObjectMeteor = new RunHitObject(Meteor.class);
        this.health = 200;
    }

    public void run() {
        super.run();     
        this.boxCollider.position.set(this.position.x - 75, this.position.y - 75);
        this.runHitObjectAlien.run(this);
        this.runHitObjectMeteor.run(this);
        System.out.print("Enemy Died On Earth:");
        System.out.println(this.enemyDiedOnEarth);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        enemyDiedOnEarth ++;
        if (this.health <= 0) {
            this.isAlive = false;
        }
        gameObject.isAlive=false;
    }

    @Override
    public void getInsight(GameObject gameObject) {

    }

}

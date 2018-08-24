/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import tower.MachineGun;
import tower.Tinker;

/**
 *
 * @author Hiep Nguyen
 */
public class Meteor extends GameObject implements PhysicBody {
    
    public Vector2D velocity;
    private int count = 10;
    public BoxCollider boxCollider;
       public FrameCounter frameCounter1 = new FrameCounter(
            this.random.nextInt(10) + 
                    95);//300
    public FrameCounter frameCounter2 = new FrameCounter(
            this.random.nextInt(8) +
                    57);//200
    public FrameCounter frameCounter3 = new FrameCounter(
            this.random.nextInt(5) +
                    65);//200
    public FrameCounter frameCounter4 = new FrameCounter(
            this.random.nextInt(10) + 
                    123);//400
    public FrameCounter frameCounter5 = new FrameCounter(
            this.random.nextInt(5) +
                    103);//300
    public FrameCounter frameCounter6 = new FrameCounter(
            this.random.nextInt(5) + 
                    60);//200

    public Meteor() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("src\\resources\\images\\comet.png", 50, 50);
        this.boxCollider = new BoxCollider(50, 50);
        this.damage = 2;
        this.health = 10;
    }
    
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.getInsight(this);
        this.getHit1();
        this.boxCollider.position.set(this.position.x - 20, this.position.y - 20);
        if (this.position.x > 1000||this.health <= 0) {
            this.isAlive = false;
        }
        
        this.velocity.set(3, 0);
        if (this.frameCounter1.run()) {//di xuong 300 300
            this.velocity.set(0, 3);
            if (this.frameCounter2.run()) {//re phai 300 500
                this.velocity.set(3, 0);
                if (frameCounter3.run()) {//di len 500 500
                    this.velocity.set(0, -3);
                    if (frameCounter4.run()) {//re phai 500 100 
                        this.velocity.set(3, 0);
                        if (frameCounter5.run()) {//di xuong 800 100
                            this.velocity.set(0, 3);
                            if (frameCounter6.run()) {//re phai 800 300
                                this.velocity.set(3, 0);
                            }
                        }
                    }
                }
            }
            
        }
    }
    
    @Override
    public void getHit(GameObject gameObject) {
        this.health -= gameObject.damage;
        if (health <= 0) {
            this.isAlive = false;
            GameObjManager.instance.allEnemyDied ++;
        }
    }
    
    public void getHit1() {
       
    }
    
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    
    @Override
    public void getInsight(GameObject gameObject) {
        MachineGun machine = GameObjManager.instance.findGun();
        if (machine != null) {
            if (Math.sqrt(Math.pow((machine.position.x - this.position.x), 2)
                    + Math.pow((machine.position.y - this.position.y), 2)) < 100) {
                this.inAction1 = true;
            } else {
                this.inAction1 = false;
            }
            
        }
        Tinker tinker = GameObjManager.instance.findTinker();
        if (tinker != null) {
            if (Math.sqrt(Math.pow((tinker.position.x - this.position.x), 2)
                    + Math.pow((tinker.position.y - this.position.y), 2)) < 200) {
                this.inAction2 = true;
            } else {
                this.inAction2 = false;
            }
            
        }
    }
}

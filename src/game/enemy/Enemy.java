package game.enemy;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;

import renderer.ImageRenderer;

import java.awt.*;
import physics.BoxCollider;

public class Enemy extends GameObject {

    public Vector2D velocity;


    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("src\\resources\\images\\circle.png", 20, 20);
        this.velocity = new Vector2D();

        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
   
        this.position.addUp(this.velocity);
         if(position.x==200){
                this.velocity.set(0, 2);
            }
         if(position.y==500){
                this.velocity.set(2, 0);
            }
         if(position.x==400){
                this.velocity.set(0, -2);
            }
         if(position.y==100){
                this.velocity.set(2, 0);
            }
         if(position.x==700){
                this.velocity.set(0, 2);
            }
         if(position.y==100&&position.x==700){
                this.velocity.set(0, 2);
            }
         if(position.y==300&&position.x==700){
                this.velocity.set(2, 0);
            }
         if(position.x>1024){
             this.isAlive=false;
         }

    }

}

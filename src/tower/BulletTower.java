/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.GameObjManager;
import base.Vector2D;
import physics.BoxCollider;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class BulletTower extends TowersObject{

   
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public BulletTower() {
        this.renderer = new ImageRenderer("src\\resources\\images\\circle.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
        this.velocity = new Vector2D();
    }

    public void run() {
        super.run();
//           Player player = GameObjManager.instance.checkCollision2(this);
//        if(player!=null){
//            this.isAlive =false;
//           
//        }
           this.boxCollider.position.set(this.position.x-2.5f,  this.position.y -2.5f);

        this.position.addUp(this.velocity);
    }

}




  





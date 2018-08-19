/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.GameObjManager;
import base.GameObject;
import physics.BoxCollider;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Tower extends GameObject {

  
    public BoxCollider boxCollider;

    public Tower() {
        position.set(500, 400);
        this.renderer = new ImageRenderer("Tower Defense (top-down)/PNG/Default size/tower1.png", 40, 40);
        this.attributes.add(new TowerShoot());
        
    }

    @Override
    public void run() {
        super.run();
      

    }
}

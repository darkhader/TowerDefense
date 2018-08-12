/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.GameObjManager;
import physics.BoxCollider;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Tower extends TowersObject {

  
    public BoxCollider boxCollider;

    public Tower() {
        position.set(300, 400);
        this.renderer = new ImageRenderer("D:\\New folder\\TowerDefenseVer\\src\\resources\\images\\circle.png", 30, 30);
        this.attributes.add(new TowerShoot());
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
      

    }
}

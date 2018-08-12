/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.FrameCounter;
import base.GameObjManager;
import base.Vector2D;

/**
 *
 * @author Hiep Nguyen
 */
public class TowerShoot extends TowersObject implements TowerAttribute<Tower> {

    private FrameCounter frameCounter = new FrameCounter(30);



    public void run(Tower tower) {
           if (this.frameCounter.run()) {
       
                BulletTower bulletTower = new BulletTower();
                bulletTower.position.set(tower.position);
                bulletTower.velocity.set(2,0);
                GameObjManager.instance.add(bulletTower);
        this.frameCounter.reset();
           }
    
        
    }
}

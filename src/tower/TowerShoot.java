/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;

/**
 *
 * @author Hiep Nguyen
 */
public class TowerShoot extends GameObject implements Attribute<Tower> {

    private FrameCounter frameCounter = new FrameCounter(100);

    public void run(Tower tower) {
        if (this.frameCounter.run()) {
            BulletTower bulletTower = new BulletTower();
            bulletTower.position.set(tower.position);
            bulletTower.velocity.set(-1, 0);
            GameObjManager.instance.add(bulletTower);
            this.frameCounter.reset();
        }

    }
}

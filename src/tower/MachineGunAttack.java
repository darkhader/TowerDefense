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
import game.enemy.Alien;

/**
 *
 * @author Hiep Nguyen
 */
public class MachineGunAttack implements Attribute<MachineGun> {

    private FrameCounter frameCounter;


    public MachineGunAttack() {
        this.frameCounter = new FrameCounter(5);

    }

    public void run(MachineGun gameObject) {

        if (this.frameCounter.run()) {
            BulletMachineGun bulletMachineGun = GameObjManager.instance.recycle(BulletMachineGun.class);
            bulletMachineGun.position.set(gameObject.position);
          
            this.frameCounter.reset();
        }
    }

}

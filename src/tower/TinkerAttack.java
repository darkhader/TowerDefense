/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;

/**
 *
 * @author Hiep Nguyen
 */
public class TinkerAttack  implements Attribute<Tinker>{
    private FrameCounter frameCounter;


    public TinkerAttack() {
        this.frameCounter = new FrameCounter(10);

    }

    public void run(Tinker gameObject) {

        if (this.frameCounter.run()) {
            BulletTinker bulletTinker = GameObjManager.instance.recycle(BulletTinker.class);
            bulletTinker.position.set(gameObject.position.x-25,gameObject.position.y-2);
          if(bulletTinker.isAlive==false){
               this.frameCounter.reset();
          }
           
        }
    }


}


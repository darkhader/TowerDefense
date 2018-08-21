/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import base.Attribute;
import base.GameObjManager;
import input.KeyBoardInput;
import tower.MachineGun;

/**
 *
 * @author Hiep Nguyen
 */
public class PlayerBuild  implements Attribute<Player> {
public int n=1;
    @Override
    public void run(Player gameObject) {
     if(KeyBoardInput.instance.isSpace && n !=0){
         float a = gameObject.position.x;
         float b = gameObject.position.y;
         GameObjManager.instance.add(new MachineGun(a,b));
         n=n-1;
  
     }
    }
    
}

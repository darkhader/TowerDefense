/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import base.Attribute;
import base.GameObjManager;
import input.KeyBoardInput;
import tower.Tinker;
import tower.MachineGun;

/**
 *
 * @author Hiep Nguyen
 */
public class PlayerBuild implements Attribute<Player> {

    public static int n = 1;
    public static int m = 1;
    public static PlayerBuild instance = new PlayerBuild();

    @Override
    public void run(Player gameObject) {
        if (KeyBoardInput.instance.is1 && n != 0) {
            float a = gameObject.position.x;
            float b = gameObject.position.y;
            GameObjManager.instance.add(new MachineGun(a, b));
            n = n - 1;

        }
        if (KeyBoardInput.instance.is2 && m != 0) {
            float a = gameObject.position.x;
            float b = gameObject.position.y;
            GameObjManager.instance.add(new Tinker(a, b));
            m = m - 1;

        }

    }

}

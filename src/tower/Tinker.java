/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

import base.GameObject;
import renderer.ImageRenderer;

/**
 *
 * @author Hiep Nguyen
 */
public class Tinker extends GameObject{
        
    public Tinker(float x, float y) {
        this.position.set(x, y);
        this.renderer = new ImageRenderer("resources/images/laser-gun.png", 30, 30);
        this.attributes.add(new TinkerAttack());
    }

    public void run() {	
        super.run();

    }
}



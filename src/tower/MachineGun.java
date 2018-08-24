package tower;

import base.Attribute;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import java.awt.Graphics;
import java.util.List;
import renderer.ImageRenderer;

/**
 * This class creates a single blackhole tower
 *
 * @author basilvetas
 */
public class MachineGun extends GameObject {

  

    /**
     * Constructor
     */
    
    public MachineGun(float x, float y) {
        this.position.set(x, y);
        this.renderer = new ImageRenderer("resources/images/machine_gun_PNG56.png", 30, 30);
        this.attributes.add(new MachineGunAttack());
    }

    public void run() {	
        super.run();

    }
}

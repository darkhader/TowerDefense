package game.enemy;

import game.enemy.Enemy;
import game.enemy.ImageLoader;
import game.enemy.PathPosition;
import physics.BoxCollider;

/**
 * This class creates a single alien enemy
 * 
 * @author basilvetas
 */
public class Alien extends Enemy
{
	
	Alien(PathPosition p)
	{
            
		ImageLoader loader = ImageLoader.getLoader();
		this.enemy = loader.getImage("resources/images/Alien-Ship.png");
		this.position1 = p;
		this.anchorX = -20;
		this.anchorY = -20;
		this.velocity = 1;
                
	}

}

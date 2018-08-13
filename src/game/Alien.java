package game;

/**
 * This class creates a single alien enemy
 * 
 * @author basilvetas
 */
public class Alien extends Enemy 
{
	/**
	 * Constructor
	 */
	Alien(PathPosition l)
	{
		ImageLoader loader = ImageLoader.getLoader();
		this.enemy = loader.getImage("resources/images/Alien-Ship.png");
		this.position = l;
		this.anchorX = -20;
		this.anchorY = -20;
		this.velocity = 1;
	}

}

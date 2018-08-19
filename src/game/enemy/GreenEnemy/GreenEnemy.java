package game.enemy.GreenEnemy;

import game.enemy.Enemy;
import game.enemy.EnemyMove;
import renderer.ImageRenderer;

/**
 * This class creates a single alien enemy
 * 
 * @author basilvetas
 */
public class GreenEnemy extends Enemy
{

	GreenEnemy()
	{
            
		this.renderer = new ImageRenderer("Tower Defense (top-down)/PNG/Default size/enemy1.png", 20, 20);
		this.enemyMove = this.line.getStart();

	}



}

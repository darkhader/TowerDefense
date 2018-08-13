package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This is an abstract superclass for an enemy in the game
 *
 * @author basilvetas
 *
 */
abstract public class Enemy {

    /* instance variables */
    protected PathPosition position;	// holds current position of enemy
    protected Image enemy;				// holds image of enemy
    protected int anchorX;				// shifts position on x axis
    protected int anchorY;				// shifts position on y axis
    protected double velocity;


	public void advance() {
        position.advance(1 + velocity);	// advances position 10 units plus velocity
    }

    /**
     * Draws the enemy to the screen
     *
     * @param g
     */
    public void draw(Graphics g) {
        // Draws Enemy object
        Coordinate c = position.getCoordinate();
        g.drawImage(enemy, c.x + anchorX, c.y + anchorY, null);

    }

    /**
     *
     * @return
     */
    public PathPosition getPosition() {
        return position;
    }

}

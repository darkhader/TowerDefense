package game.enemy;
/**
* A simple class for representing x, y coordinates.  Note
* that the fields are not private.  This allows you to
* directly access the x, y values without calling a method.
* This is common for very, very simple classes.
* 
* @author vetas
* @date 3/27/13
*/
public class Coordinate
{

	public int x, y;

	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Get X coordinate
	 * 
	 * @return X coordinate
	 */
	public int getX()
	{
		return this.x; 
	}
	
	/**
	 * Get Y coordinate
	 * 
	 * @return Y coordinate
	 */
	public int getY()
	{
		return this.y; 
	}
	
	public String toString()
	{
		return ("" + x + " " + y);
	}

}
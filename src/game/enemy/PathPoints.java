package game.enemy;

import base.Vector2D;

import java.util.*;


public class PathPoints {

    public List<Coordinate> path;

    public PathPoints(Scanner s) {
        path = new ArrayList<>();		// creates new ArrayList of Coordinates
        int counter = s.nextInt(); 				// reads number of coordinates c

        for (int n = 0; n < counter; n++) // loops n times
        {
            // builds coordinate object
            Coordinate newPath = new Coordinate(s.nextInt(), s.nextInt());
            path.add(newPath);	// adds coordinate object to path list

        }
    }

    public EnemyMove getStart() {
        return new EnemyMove(new ArrayList<>(path));
    }
}

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.InputStream;
import java.util.*;

/**
 * /**
 * A PathPoints object represents a list of coordinates along a path. This is
 * really just a helper class for loading path points, drawing the path, and for
 * creating coordinates at the start of a path. It serves no other purpose.
 *
 * @author basilvetas
 */
public class PathPoints {

    private List<Coordinate> path;

    public PathPoints(Scanner s) {
        path = new ArrayList<Coordinate>();		// creates new ArrayList of Coordinates
        int counter = s.nextInt(); 				// reads number of coordinates c

        for (int n = 0; n < counter; n++) // loops n times
        {
            // builds coordinate object
            Coordinate c = new Coordinate(s.nextInt(), s.nextInt());
            path.add(c);	// adds coordinate object to path list

        }
    }

    public PathPosition getStart() {
        return new PathPosition(new ArrayList<Coordinate>(path));
    }
}

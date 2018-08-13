/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import base.FrameCounter;
import base.GameObject;
import java.awt.Graphics;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hiep Nguyen
 */
public class CreateAlien {
    		ClassLoader myLoader = this.getClass().getClassLoader();
        InputStream pointStream = myLoader.getResourceAsStream("resources\\path_1.txt");
        Scanner s = new Scanner (pointStream);
    

    private PathPoints line = new PathPoints(s);
    List<Enemy> enemies = new ArrayList<>();
    public FrameCounter frameCounter = new FrameCounter(30);

    public void run() {
        for (Enemy e : new ArrayList<Enemy>(enemies)) {
            e.advance();
            if (e.getPosition().isAtTheEnd()) {
                enemies.remove(e);

            }

        }

        this.generateEnemies();

    }

    public void render(Graphics graphics) {
        for (Enemy e : new LinkedList<Enemy>(enemies)) {
            e.draw(graphics);
        }
    }

    private void generateEnemies() {

        if (frameCounter.run()) // slow 
        {
            enemies.add(new Alien(line.getStart()));
        }

    }
}

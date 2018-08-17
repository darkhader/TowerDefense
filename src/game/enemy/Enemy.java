package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import physics.BoxCollider;
import renderer.ImageRenderer;
import tower.BulletTower;

/**
 * This is an abstract superclass for an enemy in the game
 *
 * @author basilvetas
 *
 */
public class Enemy extends GameObject {

    ClassLoader myLoader = this.getClass().getClassLoader();
    InputStream pointStream = myLoader.getResourceAsStream("resources\\path_1.txt");
    Scanner s = new Scanner(pointStream);

    public PathPoints line = new PathPoints(s);
    List<Enemy> enemies = new ArrayList<>();

    public FrameCounter frameCounter = new FrameCounter(300);

    public PathPosition position1;
    public Image enemy;
    public int anchorX;
    public int anchorY;
    public double velocity;

    public BoxCollider boxCollider = new BoxCollider(20, 20);

    ;

    public Enemy() {

    }

    public void advance() {

        position1.advance(1 + velocity);

    }

    public void run() {

        for (Enemy e : new ArrayList<Enemy>(enemies)) {
            e.advance();
            if (e.getPosition().isAtTheEnd()) {
                enemies.remove(e);
            }
            this.boxCollider.position.set(position1.ballX, position1.ballY);
            BulletTower bulletTower = GameObjManager.instance.checkCollision(this);
            if (bulletTower != null) {
                bulletTower.isAlive = false;
                enemies.remove(e);
            }

        }

        this.generateEnemies();

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 270, 130, 60);
        graphics.fillRect(70, 330, 60, 190);
        graphics.fillRect(130, 470, 200, 50);
        graphics.fillRect(270, 170, 60, 300);
        graphics.fillRect(330, 170, 150, 50);
        graphics.fillRect(430, 220, 50, 240);
        graphics.fillRect(480, 410, 150, 50);
        for (Enemy e : new ArrayList<Enemy>(enemies)) {
            e.draw(graphics);

        }

    }

    public void draw(Graphics g) {

        Coordinate c = position1.getCoordinate();

        g.drawImage(enemy, c.x + anchorX, c.y + anchorY, null);

    }

    public PathPosition getPosition() {
        return position1;
    }

    private void generateEnemies() {

        if (frameCounter.run()) {
            enemies.add(new Alien(line.getStart()));
            frameCounter.reset();
        }
    }
}

package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import base.Vector2D;
import physics.BoxCollider;
import renderer.Renderer;
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

    public EnemyMove enemyMove;

    public BoxCollider boxCollider = new BoxCollider(20, 20);



    public Enemy() {
        this.enemyMove = new EnemyMove(this.line.path);
        this.enemyMove.position.set(this.position);
    }
    @Override
    public void run() {
        super.run();
        this.enemyMove.getPath();
        while (!this.enemyMove.isAtTheEnd()) {
            if (!this.enemyMove.isAtTheEndOfPath()) {
                enemyMove.run();
            } else {
                this.enemyMove.getPath();
                this.enemyMove.getVelocity();
            }
        }

        //nếu enemy chưa chạy đến cuối đường thì chạy hàm if
        //nếu enemy chưa chạy hết path hiện tại thì sẽ addUp velociy, còn nếu đã chạy hết thì getPath mới và getVelocity mới

//        this.boxCollider.position.set(enemyMove.position.x, enemyMove.position.y);
//            BulletTower bulletTower = GameObjManager.instance.checkCollision(this);
//            if (bulletTower != null) {
//                bulletTower.isAlive = false;
//
//            }


        //this.generateEnemies();

    }

    public EnemyMove getPosition() {
        return enemyMove;
    }
//
//      private void generateEnemies() {
//
//        if (frameCounter.run()) {
//            enemies.add(new GreenEnemy(line.getStart()));
//            frameCounter.reset();
//        }
//    }
}

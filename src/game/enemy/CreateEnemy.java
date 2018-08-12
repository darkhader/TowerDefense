package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import game.enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemy extends GameObject {

    Enemy enemy = new Enemy();

    public CreateEnemy() {

    }

    @Override
    public void run() {
        super.run();
        enemy.position.set(0, 300);
        enemy.velocity.set(2, 0);
        GameObjManager.instance.add(enemy);

    }

}

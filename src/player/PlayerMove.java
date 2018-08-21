/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author Hiep Nguyen
 */
import base.Attribute;
import base.Vector2D;
import input.KeyBoardInput;

import java.util.Random;

public class PlayerMove implements Attribute<Player> {

    private Random random = new Random();

    @Override
    public void run(Player gameObject) {

        if (KeyBoardInput.instance.isLeft) {
            gameObject.position.subtractBy(5, 0);
        }

        if (KeyBoardInput.instance.isRight) {
            gameObject.position.addUp(5, 0);
        }

        if (KeyBoardInput.instance.isUp) {
            gameObject.position.subtractBy(0, 5);
        }
        if (KeyBoardInput.instance.isDown) {
            gameObject.position.addUp(0, 5);
        }

        this.backToScreen(gameObject.position);
    }

    private void backToScreen(Vector2D position) {
        if (position.x > 1024) {
            position.set(0, this.random.nextInt(600));
        }
        if (position.x < 0) {
            position.set(1024, this.random.nextInt(600));
        }
        if (position.y > 600) {
            position.set(this.random.nextInt(1024), 0);
        }
        if (position.y < 0) {
            position.set(this.random.nextInt(1024), 600);
        }
    }
}

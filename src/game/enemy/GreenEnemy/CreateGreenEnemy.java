package game.enemy.GreenEnemy;

import action.Action;
import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;

import java.util.ArrayList;
import java.util.List;

public class CreateGreenEnemy extends GameObject {

    private FrameCounter frameCounter;

    public CreateGreenEnemy() {
        this.frameCounter = new FrameCounter(60);

    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            GreenEnemy greenEnemy = new GreenEnemy();
            greenEnemy.position.set(0, 300);
            GameObjManager.instance.add(greenEnemy);
            this.frameCounter.reset();
        }
    }

    //tạo greenEnemy rồi add vào instance


}

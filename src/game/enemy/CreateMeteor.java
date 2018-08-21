/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import java.util.Random;

/**
 *
 * @author Hiep Nguyen
 */
public class CreateMeteor extends GameObject{
        private FrameCounter frameCounter = new FrameCounter(500);

    private Random random = new Random();

    public CreateMeteor() {
        this.ConfigAction();
    }

    public void ConfigAction() {
        this.addAction(
                new LimitAction(50,
                        new SequenceAction(
                                new WaitAction(300),
                                new ActionAdapter() {
                            public boolean run(GameObject owner) {
                                Meteor meteor = new Meteor();
                                meteor.position.set(0, random.nextInt(40)+280);
                                GameObjManager.instance.add(meteor);
                                return true; 
                            }

                        }
                        )
                )
        );
    }
}


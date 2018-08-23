/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import base.FrameCounter;
import base.Vector2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import player.PlayerBuild;

/**
 *
 * @author Hiep Nguyen
 */
public class KeyBoardInput implements KeyListener {

    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean isUp = false;
    public boolean isDown = false;
    public boolean isSpace = false;
    public boolean is1 = false;
    public boolean is2 = false;

    static public KeyBoardInput instance = new KeyBoardInput();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeft = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            
            isUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           
            isDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {

            is1 = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {

            is2 = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeft = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {

            isUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            isDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            isSpace = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            PlayerBuild.instance.n = 1;
            is1 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            PlayerBuild.instance.m = 1;
            is2 = false;
        }
    }
}

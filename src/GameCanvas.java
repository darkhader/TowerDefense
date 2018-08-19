
import base.GameObjManager;

import base.GameObject;
import game.background.Background;
import game.enemy.Enemy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import game.enemy.GreenEnemy.CreateGreenEnemy;
import game.map.Map;
import tower.Tower;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphics;

    private Random random = new Random();

    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);

    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();

    }

    private void setupCharacter() {
        GameObjManager.instance.add(new Background());
        GameObjManager.instance.add(new Map());
        GameObjManager.instance.add(new CreateGreenEnemy());
        GameObjManager.instance.add(new Tower());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        GameObjManager.instance.renderAll(graphics);

        this.repaint();
    }

    public void runAll() {

        GameObjManager.instance.runAll();

    }
}

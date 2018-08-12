
import base.GameObjManager;
import game.background.Background;
import game.enemy.CreateEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import tower.Tower;
import tower.TowersObject;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Background background = new Background();

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
        GameObjManager.instance.add(new CreateEnemy());
     
        GameObjManager.instance.add(new Tower());

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        GameObjManager.instance.renderAll(graphics);
       
        graphics.setColor(Color.BLUE);

        graphics.drawLine(0, 300, 200, 300);
        graphics.drawLine(200, 300, 200, 500);
        graphics.drawLine(200, 500, 400, 500);
        graphics.drawLine(400, 500, 400, 100);
        graphics.drawLine(400, 100, 700, 100);
        graphics.drawLine(700, 100, 700, 300);
        graphics.drawLine(700, 300, 1024, 300);
        
        this.repaint();
    }

    public void runAll() {

        GameObjManager.instance.runAll();
     
    }
}

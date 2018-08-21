

import base.GameObjManager;
import base.Vector2D;
import tower.MachineGun;


import game.background.Background;
import game.enemy.CreateAlien;
import game.enemy.CreateMeteor;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import player.Player;

public class GameCanvas extends JPanel {


    private BufferedImage backBuffered;
    private Background background = new Background();

    private Graphics graphics;

    private Random random = new Random();

    public MachineGun newBlackHole;
    private boolean placingBlackHole;

    public GameCanvas() {
    
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
        newBlackHole = null;
        placingBlackHole = false;

    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();

    }

    private void setupCharacter() {
        GameObjManager.instance.add(new Background());

        GameObjManager.instance.add(new Player());
        GameObjManager.instance.add(new CreateAlien());
        GameObjManager.instance.add(new CreateMeteor());
  

    }

 

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        GameObjManager.instance.renderAll(graphics);
 graphics.setColor(Color.yellow);
 graphics.drawLine(0, 300, 300, 300);
 graphics.drawLine(300, 300, 300, 500);
 graphics.drawLine(300, 500, 500, 500);
 graphics.drawLine(500, 500, 500, 100);
 graphics.drawLine(500, 100, 800, 100);
 graphics.drawLine(800, 100, 800, 300);
 graphics.drawLine(800, 300, 1024, 300);

        this.repaint();
    }

    public void runAll() {

        GameObjManager.instance.runAll();

    }
}

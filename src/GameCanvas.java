
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.Earth.CreateEarth;
import game.Earth.Earth;
import tower.MachineGun;

import game.background.Background;
import game.enemy.Alien;
import game.enemy.CreateAlien;
import game.enemy.CreateMeteor;
import game.score.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import player.Player;

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
        GameObjManager.instance.add(new CreateEarth());
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

        this.repaint();
    }

    public void runAll() {
     
        GameObjManager.instance.runAll();

    }

 
}

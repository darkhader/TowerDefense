package game.map;

import base.Vector2D;
import renderer.Renderer;

import java.awt.*;

public class MapRenderer implements Renderer {

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 270, 130, 60);
        graphics.fillRect(70, 330, 60, 190);
        graphics.fillRect(130, 470, 200, 50);
        graphics.fillRect(270, 170, 60, 300);
        graphics.fillRect(330, 170, 150, 50);
        graphics.fillRect(430, 220, 50, 240);
        graphics.fillRect(480, 410, 150, 50);
    }
}

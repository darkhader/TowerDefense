package game.map;

import base.GameObject;

import java.awt.*;


public class Map extends GameObject{

    public Map() {
        this.renderer = new MapRenderer();
    }
}

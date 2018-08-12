package base;


import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import physics.BoxCollider;
import tower.TowersObject;

/**
 *
 * @author Hiep Nguyen
 */
public class GameObjManager {

    public List<GameObject> list;
    public List<GameObject> templeList;
    public List<TowersObject> templeListT;
    public List<TowersObject> listT;

    static public GameObjManager instance = new GameObjManager();


    public GameObjManager() {
        list = new ArrayList<>();
        listT = new ArrayList<>();
        templeList = new ArrayList<>();
        templeListT = new ArrayList<>();

    }

    public void add(GameObject gameObject) {
        this.templeList.add(gameObject);
       

    }
    public void add(TowersObject tower) {
        this.templeListT.add(tower);
       

    }

    public void runAll() {
        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.run());
        list.addAll(this.templeList);

        templeList.clear();
        
        
        listT.stream().filter(tower -> tower.isAlive).forEach(tower -> tower.run());
        listT.addAll(this.templeListT);

        templeListT.clear();

    }

    public void renderAll(Graphics graphics) {

        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.render(graphics));
        listT.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.render(graphics));
    }

}

package base;


import game.enemy.Alien;

import game.enemy.Enemy;
import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import physics.BoxCollider;
import tower.BulletTower;


/**
 *
 * @author Hiep Nguyen
 */
public class GameObjManager {

    public List<GameObject> list;
    public List<GameObject> templeList;
  
 

    static public GameObjManager instance = new GameObjManager();


    public GameObjManager() {
        list = new ArrayList<>();

        templeList = new ArrayList<>();

    

    }

    public void add(GameObject gameObject) {
        this.templeList.add(gameObject);
       

    }
  
 

    public void runAll() {
        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.run());
        list.addAll(templeList);

        templeList.clear();

    }

    public void renderAll(Graphics graphics) {

        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.render(graphics));
 
    }
    public BulletTower checkCollision(Enemy enemy){
          return (BulletTower) this.list.stream()
                .filter(GameObj -> GameObj.isAlive)
                .filter(gameObject -> gameObject instanceof BulletTower)
                .filter(gameObject -> {
                    BoxCollider other = ((BulletTower) gameObject).boxCollider;
                    return enemy.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
          
    }
    

}

package base;


import game.enemy.Enemy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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

//    public <T extends GameObject> T recycle(Class<T> cls) {
//        T object = (T) this.list
//                .stream()
//                .filter(gameObject -> !gameObject.isAlive)
//                .filter(gameObject -> cls.isInstance(gameObject))
//                .findFirst()
//                .orElse(null);
//
//        if (object != null) {
//            object.isAlive = true;
//            return object;
//        } else {
//            try {
//                object = cls.newInstance();
//                this.add(object);
//                return object;
//            } catch (InstantiationException | IllegalAccessException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//    }
    

}

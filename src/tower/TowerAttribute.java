/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower;

/**
 *
 * @author Hiep Nguyen
 */
public interface TowerAttribute<T extends TowersObject> {

    void run(T tower);
}
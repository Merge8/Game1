/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import javax.swing.ImageIcon;

/**
 *
 * @author michaeldepinto
 */
public class Ghost extends Enemy {
    
    ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostLeft.png");
    ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostRight.png");

    Ghost() {
        health = 100;
        spawnX = 100;
        spawnY = 475;
        hitboxX = 75;
        hitboxY = 75;
        still = i.getImage();
        x = spawnX;
        y = spawnY;


    }
}

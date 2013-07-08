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
    
    ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/ghostLeft.png");
    ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/ghostRight.png");

    Ghost() {
        health = 100;
        spawnX = 500;
        spawnY = 475;
        hitboxX = 75;
        hitboxY = 75;
        still = i.getImage();
        x = spawnX;
        y = spawnY;
        xpValue = 10;


    }
}

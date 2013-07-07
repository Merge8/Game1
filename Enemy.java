/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author michaeldepinto
 */
public class Enemy {
    int x, dx, y, dy, spawnX, spawnY, faceLeft, faceRight,health, hitboxX, hitboxY;
    Image still, left, right;
    boolean alive = true;
    int isAlive = 1;
    
    //ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostLeft.png");
    //ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostRight.png");

public Enemy(){
    
    
    
}
public void checkAlive(){
       if (health <=0){
    isAlive = 0;
    }  
    }
public void alive(){
    if (health <=0){
    alive = false;
    }
}
    public int getY() {
        return y;
    }
    public int getX(){
        return x;
    }
    public Image getImage() {
        return still;
    }
    public int getIsAlive(){
        return isAlive;
    }
    
    
    
public int getHealth(){
    return health;
}        
    
public void mobMove(){
  
    
   
           


}
 public Rectangle getBounds()
        {
                return new Rectangle(x,y, hitboxX, hitboxY);
        }
       
    
    
    
// class end
}

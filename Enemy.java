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
    boolean alive;
    //ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostLeft.png");
    //ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/ghostRight.png");

public Enemy(){
    
    
    
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
    
    
    
        
    
public void mobMove(){
  
    
   
           


}
 public Rectangle getBounds()
        {
                return new Rectangle(x,y, hitboxX, hitboxY);
        }
       
    
    
    
// class end
}

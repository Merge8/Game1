/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author michaeldepinto
 */
public class MainAttack {
    int x,y, xl;
	Image img, imgL;
	boolean visible;
	
	public MainAttack(int startX, int startY)
	{
		x = startX;
		y = startY;
		ImageIcon newAttack = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/attack1.png");
		ImageIcon newAttackLeft = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/attack2.png");
		imgL = newAttackLeft.getImage();
                img = newAttack.getImage();
		visible = true;
                
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 75, 30);
	}
        public Rectangle getBoundsLeft(){
            return new Rectangle(x -120, y, 75, 30);
        }
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean getVisible()
	{
		return visible;
	}
	public Image getImage()
	{
		return img;
	}
        public Image getImageLeft(){
            return imgL;
        }
	
	
	public void setVisible(boolean isVisible)//down
	{
		visible = isVisible;
	}
	public void move()
	{
           
		x = x;
		if ( x > 900)
			visible = false;
	}
        
        

}

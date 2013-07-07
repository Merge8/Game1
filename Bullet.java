/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.*;

import javax.swing.ImageIcon;

public class Bullet {

	int x,y;
	Image img;
	boolean visible;
	
	public Bullet(int startX, int startY)
	{
		x = startX;
		y = startY;
		ImageIcon newBullet = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/bulletd.png");
		img = newBullet.getImage();
		visible = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 31, 8);
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
	
	public void move()
	{
           
		x = x + 2;
		if ( x > 900)
			visible = false;
	}
        public void moveLeft(){
            x = x - 2;
            if (x > 900){
                visible = false;
            }
        }
	
	public void setVisible(boolean isVisible)//down
	{
		visible = isVisible;
	}
	

}
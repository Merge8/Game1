/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author michaeldepinto
 */

public class Bullet {
	int x, y;//-- Controls the CURRENT location of THIS bullet
	//Each object of this class is a new BULLET
	 Image img;
	boolean visible;
	//sets weather THIS bullet is visible or not

	
	public int getX()
	{
		return x;
	}

	public boolean getVisible()
	{
		return visible;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return img;
	}
	
	public Bullet(int startX, int startY)
	{
                ImageIcon newBullet = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/bullet.png");
		img = newBullet.getImage();
		x = startX;
		y = startY;
		visible = true;
	}
	//Just like the move class in Dude class...
	public void move(){
		x = x + 2; //x + bullet speed
		if (x > 700)// if x > board width
			//Make the bullet invisible
			visible = false;
	}
}    

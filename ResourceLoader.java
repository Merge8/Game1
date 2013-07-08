/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;
import java.awt.Image;
import java.awt.Toolkit;

public class ResourceLoader {
	
	static ResourceLoader rl = new ResourceLoader();
	
	public static Image getImage(String fileName){
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/" + fileName));
	}
	
}
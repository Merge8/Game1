/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import static GameTest.Board.font;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author michaeldepinto
 */
public class MainMenu extends JPanel implements ActionListener {
        static Font font = new Font("SanSerif", Font.BOLD, 20);

    
    public MainMenu(){
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
repaint();
    
    }
    public void paint(Graphics g) {

      super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // display char top bar
        
        
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Level: + p.getLevel() +  + p.getHealth() + ", 50, 50);
    
        //
        
        g2d.setFont(font);
        g2d.setColor(Color.BLUE);
     //   g2d.drawString("Ammo left: " + p.ammo, 500, 50);
    }
}

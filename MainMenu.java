/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author michaeldepinto
 */
public class MainMenu extends Frame implements MouseListener {

    static Font font = new Font("SanSerif", Font.BOLD, 20);
    int x, y;

    public MainMenu() {
       //Timer time = new Timer(10, this);
       // time.start();
        addMouseListener(this);

    }

   
    public void actionPerformed(ActionEvent e) {
        repaint();
            
    }

    public void paint(Graphics g) {
      //  System.out.println("x");

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // display char top bar


        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Play", 175, 300);
        g2d.drawString("Store", 600, 300);
        //

        g2d.setFont(font);
        g2d.setColor(Color.BLUE);
        //   g2d.drawString("Ammo left: " + p.ammo, 500, 50);
    }

    /*private class AL extends KeyAdapter {
     * 
     * @Override
     * public void keyReleased(KeyEvent e) {
     * keyReleased(e);
     * }
     * 
     * @Override
     * public void keyPressed(KeyEvent e) {
     * keyPressed(e);
     * }
     * }*/

    @Override
    public void mouseClicked(MouseEvent e) {
       
        
        System.out.println("X = " + e.getX());
        
        System.out.println("y = " + e.getY());
     // Play Button
        if (e.getX() >= 175 && e.getX() <= 220 && e.getY() >= 284 && e.getY() <= 300 ){
        gamepage = 2;
        gamePage();
         /* JFrame play = new JFrame();
          play.add(new Board());
          play.setTitle("Game Test");
          play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          play.setSize(900, 600);
          play.setVisible(true);
          play.setLocationRelativeTo(null); 
*/
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
        }
    


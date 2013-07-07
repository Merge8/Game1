/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author michaeldepinto
 */
public class Board extends JPanel implements ActionListener {
    // Values 

    Hero p;
    Ghost en;
    Shyguy en2;
    public Image img;
    public Image floorImg;
    public Image platformImg;
    Timer time;
    boolean colide;
    static Font font = new Font("SanSerif", Font.BOLD, 24);

    public Board() {
        p = new Hero();
        en = new Ghost();
        en2 = new Shyguy();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/background.png");
        ImageIcon f = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/floor.png");
        ImageIcon platform = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/platform.png");
colide = false;
        img = i.getImage();
        floorImg = f.getImage();
        platformImg = platform.getImage();
        time = new Timer(10, this);
        time.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        mobMove();
        checkCollisions();
        p.move();
        repaint();
    }

    public void collisionTrue(){
        if (p.getX() > en.getX() && p.getX() > 100 && p.getX() < 720) {
            p.x += 100;
                         

        } else 
            if (p.getX() < en.getX() && p.getX() > 100 && p.getX() < 720){
                p.x-= 100;
            }
        
    
        
    }
    public void checkCollisions()
{
        Rectangle er1 = en.getBounds();
        Rectangle hero = p.getBounds();
        
       if (hero.intersects(er1)) {
           collisionTrue();
           System.out.println("Colide!");
           
       }
       
       
}
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;



//background image             
        g2d.drawImage(img, 0, 0, null);
        // bottom floor image
        g2d.drawImage(floorImg, 0, 545, null);
        //create platforms
        g2d.drawImage(platformImg, 0, 300, null);


//character image
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        System.out.println(p.getY());

        // Enemy Spawn
        g2d.drawImage(en.getImage(), en.getX(),en.getY(), null);
        en.mobMove();
        
      g2d.drawImage(en2.getImage(), en2.getX(),en2.getY(), null);
      en2.mobMove();
    }

    private class AL extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
    }

    
    public void mobMove(){
        if (p.getX() > en.getX()) {
            en.x++;
                            en.still = en.i.getImage();

        } else 
            if (p.getX() < en.getX()){
                en.x--;
                en.still = en.l.getImage();
            }
        
    }
// end board class
}
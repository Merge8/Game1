/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    public int v = 172;
    Thread animator;
    boolean a = false;
    boolean done2 = false;

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
        //mobMove();
        checkCollisions();
        p.move();
        repaint();


        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(w);//draw:
            if (m.getVisible() == true) {
                m.move();
            } else {
                bullets.remove(w);
            }
        }




    }

    public void collisionTrue() {
        if (p.getX() > en.getX() && p.getX() > 100 && p.getX() < 720) {
            p.x += 100;


        } else if (p.getX() < en.getX() && p.getX() > 100 && p.getX() < 720) {
            p.x -= 100;
        }



    }
    public void bulletHit(){
        en.health -=p.getAttackDamage();
        
    }

    public void checkCollisions() {
        Rectangle er1 = en.getBounds();
        Rectangle hero = p.getBounds();
        Rectangle attackZone = p.attackZone();
        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            Bullet m = (Bullet) bullets.get(w);
            Rectangle m1 = m.getBounds();
            if (m1.intersects(er1)) {
            System.out.println("Its a hit");
            bulletHit();
            bullets.remove(m);
           en.alive();
            }

        }

        if (hero.intersects(er1)) {
            collisionTrue();
            System.out.println("Colide!");
        }

        // check attack hit
        if (attackZone.intersects(er1)) {


        }


    }

    @Override
    public void paint(Graphics g) {

        if (p.dy == 1 && done2 == false) {
            done2 = true;
            animator = new Thread((Runnable) this);
            animator.start();
        }
        //p.y = v;

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

//Get bullets from ArrayList

        if ((p.getX() - 590) % 2400 == 0)// p.getX() == 590 || p.getX() == 2990)
        {
            p.nx = 0;
        }
        if ((p.getX() - 1790) % 2400 == 0)// p.getX() == 1790 || p.getX() == 4190)
        {
            p.nx2 = 0;
        }



        //background image

        g2d.drawImage(img, 0, 0, null);
        // bottom floor image
        g2d.drawImage(floorImg, 0, 545, null);
        //create platforms
        g2d.drawImage(platformImg, 0, 300, null);


        //character image
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        System.out.println(en.getHealth());

        // Enemy Spawn
        if (en.alive = true) {
            g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
            en.mobMove();
        }

        g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
        en2.mobMove();



        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(w);//draw:
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);

        }
        g2d.setFont(font);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Ammo left: " + p.ammo, 500, 50);
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

    public void mobMove() {
        if (p.getX() > en.getX()) {
            en.x++;
            en.still = en.i.getImage();

        } else if (p.getX() < en.getX()) {
            en.x--;
            en.still = en.l.getImage();
        }

    }
// end board class
    boolean hd = false;
    boolean done = false;

    public void cycle() {

        if (hd == false) {
            v--;
        }
        if (v == 125) {
            hd = true;
        }
        if (hd == true && v <= 172) {
            v++;
            if (v == 172) {
                done = true;
            }
        }
    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (done == false) {

            cycle();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 10 - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            beforeTime = System.currentTimeMillis();
        }
        done = false;
        hd = false;
        done2 = false;
    }
}

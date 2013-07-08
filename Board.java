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
import javax.print.attribute.standard.Media;
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
   public Timer time;
    boolean colide;
    static Font font = new Font("SanSerif", Font.BOLD, 20);
    public int v = 172;
    Thread animator;
    boolean a = false;
    boolean done2 = false;
    long nextSecond = System.currentTimeMillis() + 1000;
int frameInLastSecond = 0;
int framesInCurrentSecond = 0;


   // BufferedImage sprite;
   //         Animator mario;

   // Image dbImage;
   // Graphics dbg;
    public Board() {
        p = new Hero();
        en = new Ghost();
        en2 = new Shyguy();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/background.png");
        ImageIcon f = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/floor.png");
        ImageIcon platform = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/platform.png");
          Image ii = ResourceLoader.getImage("heroSprits.png");

        colide = false;
        img = i.getImage();
        floorImg = f.getImage();
        platformImg = platform.getImage();
        time = new Timer(15, this);
        time.start();
        
    }
       

    @Override
    public void actionPerformed(ActionEvent e) {
        mobMove();
        checkCollisions();
        p.move();
        repaint();
// attack command
          ArrayList attack = Hero.getAttack();
        for (int ww = 0; ww < attack.size(); ww++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            MainAttack ma = (MainAttack) attack.get(ww);//draw:
           if (p.facingWhileFired == 1){
            if (ma.getVisible() == true) {
                ma.move();
            } 
        } else
        if (p.facingWhileFired == 2){
           if (ma.getVisible() == true) {
                } else {
                attack.remove(ww);
           }
        }
           }
        
// shoot command
        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(w);//draw:
           if (p.facingWhileFired == 1){
            if (m.getVisible() == true) {
                m.move();
            } 
        } else
        if (p.facingWhileFired == 2){
           if (m.getVisible() == true) {
                m.moveLeft();
            } else {
                bullets.remove(w);
            }
        }
        }


 
       
    
long currentTime = System.currentTimeMillis();
    if (currentTime > nextSecond) {
        nextSecond += 1000;
        frameInLastSecond = framesInCurrentSecond;
        framesInCurrentSecond = 0;
      //  Mana Regen
            p.mana += p.manaRegen;
            
        
    }
        framesInCurrentSecond++;

        
    } // end action preformed

    public void bulletHit(){
        en.health -=p.getSpellDamage();
       en.checkAlive();
     
    }
    public void attackHit(){
        en.health -=p.getAttackDamage();
       en.checkAlive();
     
    }

    public void checkCollisions() {
        Rectangle er1 = en.getBounds();
        Rectangle hero = p.getBounds();
        Rectangle attackZone = p.attackZone();
       
        
       // attack Check hit 
        ArrayList attack = Hero.getAttack();
        for (int ww = 0; ww < attack.size(); ww++) {
            MainAttack ma = (MainAttack) attack.get(ww);
                 Rectangle ma1 = ma.getBounds();

            if (p.facingWhileFired == 1){
                  ma1 = ma.getBounds();

           } else if (p.facingWhileFired ==2){
                ma1 = ma.getBoundsLeft();
           }
                 if (en.isAlive == 1){   

            if (ma1.intersects(er1)) {
            System.out.println("Its a hit");
            attackHit();
           en.alive();
           p.xp += en.xpGive;
           p.levelUP();
            }
                 }
        }
        //shoot check hit
        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            Bullet m = (Bullet) bullets.get(w);
            Rectangle m1 = m.getBounds();
                 if (en.isAlive == 1){   

            if (m1.intersects(er1)) {
            System.out.println("Its a hit");
            bulletHit();
            bullets.remove(m);
           en.alive();
           p.xp += en.xpGive;
           p.levelUP();
            }
                 }
        }
        if (en.isAlive == 1){   

        if (hero.intersects(er1)) {
           collisionTrue();
           // System.out.println("Colide!");
        }
        }
        // check attack hit
        if (attackZone.intersects(er1)) {


        }


    }
    public void collisionTrue() {
               if (en.isAlive == 1){   

        if (p.getX() > en.getX() && p.getX() > 100 && p.getX() < 720) {
            p.x += 100;
            p.incomingDamage = en.damage;
            p.takeDamage();
            p.checkIfDead();

        } else if (p.getX() < en.getX() && p.getX() > 100 && p.getX() < 720) {
            p.x -= 100;
            p.incomingDamage = en.damage;
            p.takeDamage();
            p.checkIfDead();
        }
               }
}

    @Override
    public void paint(Graphics g) {

        if (p.dy == 1 && done2 == false) {
            done2 = true;
            animator = new Thread((Runnable) this);
            animator.start();
        }
       //Start Sprite code
      /*  
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, null); */
        // End Sprite Code
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
        System.out.println(en.alive);
        // Testing Sprites
        
        
        
       // g.drawImage(mario.sprite, 100, 100, 50, 50, null);

        //g2d.drawImage(ii, p.getX(),p.getY(), null);

        // Enemy Spawn
        if (en.isAlive == 1){   
        g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
            en.mobMove();
    }
        if (en.isAlive == 0) {
            en = new Ghost();
        }
/*
        g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
        en2.mobMove();
*/
           
        ArrayList bullets = Hero.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            Bullet m = (Bullet) bullets.get(w);//draw:
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);

        }
    //draw attack
        ArrayList attack = Hero.getAttack();
        for (int ww = 0; ww < attack.size(); ww++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            MainAttack ma = (MainAttack) attack.get(ww);//draw:
           if (p.facing == 1){
            g2d.drawImage(ma.getImage(), ma.getX(), ma.getY(), null);
           }
           if (p.facing == 2){
            g2d.drawImage(ma.getImageLeft(), ma.getX() - 120, ma.getY(), null);

           }
           attack.remove(ww);

        }
        // display char top bar
        
        
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Level: "+ p.getLevel() + " HP: " + p.getHealth() + " MP: " + p.getMana() + " XP: " + p.getXP() + "/" + p.getXpToLevel(), 50, 50);
            g.drawString(getFPS() + " fps", 700, 50);

        //
        
        //g2d.setFont(font);
        //g2d.setColor(Color.BLUE);
        //g2d.drawString("Ammo left: " + p.ammo, 500, 50);
    
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
    public int getFPS() {
        return frameInLastSecond;
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
     
/*
    private void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = loader.loadImage("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/heroSprits.png");
        } catch (IOException ex) {
          //  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet ss = new SpriteSheet(spriteSheet);
        
        ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
        
        sprites.add(ss.grabSprite(0, 18, 13, 15));
        sprites.add(ss.grabSprite(16, 17, 16, 16));
        sprites.add(ss.grabSprite(33, 17, 17, 16));
        
      
    } */
    
    
}

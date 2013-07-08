/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//this is crazy
package GameTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Hero {

    int x, dx, y, dy, nx2, nx, left, right, jumpCounter, ammo, ground, gravity, maxGravity, jumpHight, movementSpeed,
            attackDamage, attackX, attackY, facing, health, mana ,xp, xpToLevel, facingWhileFired, level,
            armor, incomingDamage;
    boolean Jumped = false;
    boolean attacking = false;
    Timer jumpTimer;
    Image still;
    ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/left.png");
    ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/hero.png");
    ImageIcon ar = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/heroAttack1.png");
    ImageIcon al = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/Images/heroAttackLeft1.png");
    static ArrayList bullets;
    static ArrayList bulletDirection;
    private Object time;
    public Hero() {
        ammo = 10;
        still = i.getImage();
        x = 45;
        y = 400;
        nx2 = 685;
        nx = 0;
        right = 820;
        left = 0;
        jumpCounter = 0;
        ammo = 1000;
        ground = 442;
        maxGravity = 5;
        gravity = maxGravity;
        jumpHight = -40;
        movementSpeed = 2;
        facing = 0;
        bullets = new ArrayList();
        bulletDirection = new ArrayList();
        attackDamage = 50;
health = 100;
mana = 100;
xp = 0;
xpToLevel = 0;
facingWhileFired = 0;
level = 1;
    }

    public static ArrayList getBullets() {
        return bullets;
    }
    public static ArrayList getBulletDirection(){
        return bulletDirection;
    }
    public void fire() {
        if (ammo > 0) {
            ammo--;
            //The v is from the board class, which corresponds to the character's
            //position when it is jumping, resulting in the bullet being formed
            //at a higher position when the character is at the peak of its jump
            Bullet z = new Bullet((getX() + 60), (getY() + 154 / 2));
            
            bullets.add(z);
        }
    }

    public void move() {

        x = x + dx;
        if (x < 0) {
            x = x + 2;
            dx = 0;
        }
        if (x > 820) {
            x = x - 2;
            dx = 0;
        }

        //go threw floor stopper

        //if (y > ground){
        //  y = 442;
        //}
        //gravity
        if (y < ground) {
            if (gravity < -maxGravity) {
                y -= maxGravity;
            } else if (y + gravity < ground) {
               y = y + gravity;
            } else {
                y = ground;
            }
            /*if (gravity < defaultGravity && gravity + 2 <= 2) {
             gravity += 2;
             } else if (gravity < defaultGravity) {
             gravity -= 1;
             }*/

            //gravity fall
            if (gravity + 1 < maxGravity) {
                gravity += 1;
            } else {
                gravity = maxGravity;
            }
            //floor catcher
        } else if (y > ground && y < 450) {
            y = ground;
        } else if (y == ground) {
            gravity = 0;
            jumpCounter = 0;
        }


        // nx2 = nx2 + dx;
        // nx = nx + dx;

    }
    public void jump() {
        jumpCounter++;
        y--;
        gravity = jumpHight;
    }
    public void takeDamage(){
        health -= incomingDamage;
        incomingDamage = 0;
    }
    public void checkIfDead(){
         if (health <= 0){
             /*   JFrame frame = new JFrame();
          frame.add(new MainMenu());
          frame.setTitle("Game Test");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(899, 600);
          frame.setVisible(true);
          frame.setLocationRelativeTo(null);
        
    
    */
         }
    }
public int getXpToLevel(){
        level();
        return xpToLevel;
    }
    public int getMana(){
        
        return mana;
        
    }
    public int getXP(){
        return xp;
    }
    
public int getHealth(){
    
    return health;
    
}
public int levelUP(){
    if (getXP() >= getXpToLevel()){
    level++;
    }
    
    return level;
}
public int getLevel(){
    return level;
}
    public int getAttackDamage(){
        return attackDamage;
    }
    public int getX() {
        return x;
    }

    public boolean getJumped() {
        return Jumped;
    }

    public int getJumpCounter() {
        return jumpCounter;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return still;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 76, 110);
    }

    public void level() {
        switch (getLevel()) {
            case 1: {
                xpToLevel = 100;
             
                break;
            }
            case 2: {
                xpToLevel = 250;
                break;
            }
                case 3: {
                xpToLevel = 625;
                break;
            }
                    case 4: {
                xpToLevel = 1565;
                break;
            }
            case 5: {
                xpToLevel = 3900;
                break;
            }
            case 6: {
                xpToLevel = 9750;
                break;
            }
            case 7:{
                xpToLevel = 24500;
                break;
            }    
            case 8:{
                xpToLevel = 61000;
                break;
              
            }
            case 9:{
                xpToLevel = 150000;
                break;
                
                
            }
            case 10:{ 
                xpToLevel = 381500;
                break;
            }
        }


    }
    public Rectangle attackZone() {
        attackX = getX() + 20;
        attackY = getY() + 20;



        return new Rectangle(attackX, attackY, 50, 50);

    }
    
   

    public void attack() {
        if (facing == 1) {
            still = ar.getImage();
        } else if (facing == 2) {
            still = al.getImage();
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                dx = -6;
                still = l.getImage();
                facing = 2;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                dx = 6;
                still = i.getImage();
                facing = 1;
                break;
            }
            case KeyEvent.VK_DOWN: {
                dy = 2;
                break;
            }
            case KeyEvent.VK_UP: {
                if (jumpCounter < 2) {
                    jump();
                }/*
                 if (jumpCounter <= 2) {
                 dy = -200;
                 jumpCounter++;
                 }*/
                break;
            }
            case KeyEvent.VK_SPACE: {
               facingWhileFired = facing;
                fire();
                
                break;
            }
            case KeyEvent.VK_M:{
             //   Frame.add(new MainMenu());
                break;
                
            }
        
        } // end switch

    } // end keyPressed


    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                dx = 0;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                dx = 0;
                break;
            }
            case KeyEvent.VK_DOWN: {
                dy = 0;
                break;
            }
            case KeyEvent.VK_UP: {
                dy = 0;
                break;
            }
            case KeyEvent.VK_SPACE: {
                break;
            }
        }

    }

 
}

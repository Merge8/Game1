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
import javax.swing.Timer;

public class Hero {

    int x, dx, y, dy, nx2, nx, left, right, jumpCounter, ammo, ground, gravity, maxGravity, jumpHight, movementSpeed,
            attackDamage, attackX, attackY, facing;
    boolean Jumped = false;
    boolean attacking = false;
    Timer jumpTimer;
    Image still;
    ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/left.png");
    ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/hero.png");
    ImageIcon ar = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/heroAttackRight.png");
    ImageIcon al = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/heroAttackLeft.png");
    static ArrayList bullets;

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
        ammo = 10;
        ground = 442;
        maxGravity = 5;
        gravity = maxGravity;
        jumpHight = -40;
        movementSpeed = 2;
        facing = 0;
        bullets = new ArrayList();
        attackDamage = 50;

    }

    public static ArrayList getBullets() {
        return bullets;
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

    public Rectangle attackZone() {
        attackX = getX() + 20;
        attackY = getY() + 20;



        return new Rectangle(attackX, attackY, 50, 50);

    }
   

    public void attack() {
        attacking = true;
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
                fire();
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

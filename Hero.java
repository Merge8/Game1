/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//this is crazy
package GameTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Hero {

    int x, dx, y, dy, nx2, nx, left, right, jumpCounter, ammo, ground, gravity, maxGravity, jumpHight, movementSpeed,
            attackDamage, attackX, attackY;
    boolean Jumped = false;
    boolean attacking = false;
    Timer jumpTimer;
    Image still;
    ImageIcon l = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/left.png");
    ImageIcon i = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/hero.png");
    ImageIcon ar = new ImageIcon("/Users/michaeldepinto/NetBeansProjects/GameTest/src/GameTest/heroAttackRight.png");

    public Hero() {
        still = i.getImage();
        x = 45;
        y = 200;
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
            if(gravity < -maxGravity) {
                y -= maxGravity;
            } else
            if (y + gravity < ground) {
                y = y + gravity;
            } else
                y = ground ;
            /*if (gravity < defaultGravity && gravity + 2 <= 2) {
                gravity += 2;
            } else if (gravity < defaultGravity) {
                gravity -= 1;
            }*/
            
            //gravity fall
            if(gravity + 1 < maxGravity) {
                gravity += 1;
            } else gravity = maxGravity;
            //floor catcher
        } else 
            if (y > ground && y < 450) {
            y = ground;    
        } else 
                if (y == ground) {
            gravity = 0;
            jumpCounter = 0;
        }
        
        /*
        // Jump Counter
        if (jumpCounter <= 2) {
            jump();
        }
        if (jumpCounter > 0 && y == 442) {
            jumpCounter = 0;
        }*/

       // nx2 = nx2 + dx;
       // nx = nx + dx;

    }

    public void jump() {
        jumpCounter++;
        y--;
        gravity = jumpHight;

        /*if (dy < 0) {
            y -= 6;
            dy += 5;
        } else {
            dy = 0;
        }*/


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

    
     public Rectangle getBounds()
        {
                return new Rectangle(x,y, 76, 110);
        }
     public Rectangle attackZone(){
         attackX = x + 20;
         attackY = y + 20;



        return new Rectangle(attackX,attackY, 50, 50 );
         
       }
    /*public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode();
     if (key == KeyEvent.VK_LEFT) {

     dx = -2;
     still = l.getImage();
     }

     if (key == KeyEvent.VK_RIGHT) {
     dx = 2;

     still = i.getImage();
     }
     if (key == KeyEvent.VK_DOWN) {
     dy = 2;
     }
     if (key == KeyEvent.VK_UP) {
     if (jumpCounter <= 2) {
     dy = -200;
     jumpCounter++;
     }
     }

     }*/
     
     public void attack(){
         attacking = true;
         still = ar.getImage();
         
     }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                dx = -6;
                still = l.getImage();

                break;
            }
            case KeyEvent.VK_RIGHT: {
                dx = 6;
                still = i.getImage();

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
                attack();
                break;
            }

        } // end switch

    } // end keyPressed


    /*public void keyReleased(KeyEvent e) {
     int key = e.getKeyCode();

     if (key == KeyEvent.VK_LEFT)
     dx = 0;

     if (key == KeyEvent.VK_RIGHT)
     dx = 0;
     if (key == KeyEvent.VK_DOWN)
     dy = 0;
     if (key == KeyEvent.VK_UP) {
     dy = 0;
     }}*/
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
            case KeyEvent.VK_SPACE:{
                attacking = false;
                break;
            }
        }

    }
}

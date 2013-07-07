/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameTest;

/**
 *
 * @author michaeldepinto
 */
public class Level extends Hero {

    public Level() {
        switch (level) {
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
}

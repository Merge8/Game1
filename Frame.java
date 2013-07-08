package GameTest;

import javax.swing.*;

public class Frame extends Start{

    JFrame frame = new JFrame();

    public Frame() {

        frame.add(new MainMenu());
        frame.setTitle("Game Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(899, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

   /* public void gamePage() {
        switch (gamepage) {
            case 1: {
                frame.add(new MainMenu());
                break;
            }
            case 2: {
                frame.add(new Board());
            }
        } // end switch

    } // end gamePage() */

    /*public static void main(String[] args) {
        new Frame();



    } */
}

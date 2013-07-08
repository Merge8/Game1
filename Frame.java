package GameTest;
import javax.swing.*;

public class Frame {

	public Frame(){
		JFrame frame = new JFrame();
		frame.add(new Board());	
		frame.setTitle("Game Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(899,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	

public static void main(String[] args){
		new Frame();
               
	}
}

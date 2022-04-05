package main;
import java.awt.Dimension;
import javax.swing.JFrame;
import gui.*;
public class MainClass {
	private static Calculator c;
	public static void main(String[] args) {
		c = new Calculator();
		c.setPreferredSize(new Dimension(400,400));
		c.pack();
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
	}

}

package gui;

// Java Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// My Imports
import filelist.*;
import spaceships.*;

//
//
public class SelectSpaceShipScreen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private File[] images = Images.getImages();

	public SelectSpaceShipScreen() {
		JButton[] buttons = new JButton[images.length];
		Image[] sprites = new Image[images.length];
		// Settings for this Panel
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout(5, SpaceFrame.HEIGHT / 2));
		// Grid Panel for spaceship selection
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		FlowLayout myFlow = new FlowLayout(FlowLayout.CENTER, 0, SpaceFrame.height / 3);
		buttonPanel.setLayout(myFlow);
		// buttonPanel.setPreferredSize(new Dimension(500 ,100));

		// Scan for Images and create the buttons
		for (int i = 0; i < images.length; i++) {
			try {
				if (!images[i].getName().equals("ENEMY.png")) {
					sprites[i] = ImageIO.read(new FileInputStream(images[i]));
					buttons[i] = new JButton();
					buttons[i].setPreferredSize(new Dimension(100, 100));
					buttons[i].setBorder(new LineBorder(Color.BLACK));
					buttons[i].setBackground(Color.BLACK);
					buttons[i].setIcon(new ImageIcon(sprites[i]));
					// /buttons[i].setPreferredSize(new Dimension(100, 100));
					buttonPanel.add(buttons[i]);
					buttons[i].addActionListener(this);
					buttons[i].setActionCommand(String.valueOf(i));
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		// Create label and configure label
		JLabel myLabel = new JLabel("Please choose your Spaceship");
		myLabel.setForeground(Color.WHITE);
		myLabel.setHorizontalAlignment(JLabel.CENTER);
		// Add finalized panels to main Frame
		this.add(myLabel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		int index = Integer.valueOf(action);
		String name = images[index].getName();
		switch (name) {
		case "ALPHA.png":
			SpaceFrame.userspaceship = new SpaceshipAlpha();
			SpaceFrame.userspaceship.setIcon(images[index]);
			SpaceFrame.gameplay.setUserSpaceShip(SpaceFrame.userspaceship);
			SpaceFrame.cardLayout.show(this.getParent(), "gameplay");
			break;
		case "BETA.png":
			SpaceFrame.userspaceship = new SpaceshipBeta();
			SpaceFrame.userspaceship.setIcon(images[index]);
			SpaceFrame.gameplay.setUserSpaceShip(SpaceFrame.userspaceship);
			SpaceFrame.cardLayout.show(this.getParent(), "gameplay");
			break;
		case "DELTA.png":
			SpaceFrame.userspaceship = new SpaceshipDelta();
			SpaceFrame.userspaceship.setIcon(images[index]);
			SpaceFrame.gameplay.setUserSpaceShip(SpaceFrame.userspaceship);
			SpaceFrame.cardLayout.show(this.getParent(), "gameplay");
			break;
		case "GAMA.png":
			SpaceFrame.userspaceship = new SpaceshipGama();
			SpaceFrame.userspaceship.setIcon(images[index]);
			SpaceFrame.gameplay.setUserSpaceShip(SpaceFrame.userspaceship);
			SpaceFrame.cardLayout.show(this.getParent(), "gameplay");
			break;
		case "ZERO.png":
			SpaceFrame.userspaceship = new SpaceshipZero();
			SpaceFrame.userspaceship.setIcon(images[index]);
			SpaceFrame.gameplay.setUserSpaceShip(SpaceFrame.userspaceship);
			SpaceFrame.cardLayout.show(this.getParent(), "gameplay");
			break;
		default:
			System.out.println("ERROR");
		}
	}
}

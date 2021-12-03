package gui;

import java.awt.CardLayout;
import javax.swing.*;
import spaceships.*;

public class SpaceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static int width;
	protected static int height;
	protected static SelectSpaceShipScreen spaceshipSelection;
	protected static GamePlayScreen gameplay;
	protected static CardLayout cardLayout = new CardLayout();
	protected static Spaceship userspaceship ;
	protected static SpaceshipEnemy enemyspaceship;
	//private static JPanel spaceFramePanel = new JPanel();

	public SpaceFrame(int width, int height) {
		SpaceFrame.width = width;
		SpaceFrame.height = height;
		this.setSize(SpaceFrame.width, SpaceFrame.height);
		this.setTitle("Week 7");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(cardLayout);
		setupMasterPanel();
		setResizable(false);
		this.setVisible(true);

	}

	void setupMasterPanel() {
		spaceshipSelection = new SelectSpaceShipScreen();
		this.add(spaceshipSelection , "selection");
		gameplay = new GamePlayScreen(); 
		this.add(gameplay , "gameplay");
	}
}

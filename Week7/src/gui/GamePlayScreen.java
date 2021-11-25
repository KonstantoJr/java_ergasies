package gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import spaceships.*;

public class GamePlayScreen extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;

	private Spaceship userSpaceShip;

	GamePlayScreen() {
		addKeyListener(this);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		userSpaceShip.getIcon().paintIcon(this,g,userSpaceShip.getX() , userSpaceShip.getY());
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) userSpaceShip.moveUp(); 
		if (e.getKeyCode() == KeyEvent.VK_DOWN) userSpaceShip.moveDown(); 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) userSpaceShip.moveRight(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) userSpaceShip.moveLeft();
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	protected void setUserSpaceShip(Spaceship uses) {
		userSpaceShip = uses;
	}
}

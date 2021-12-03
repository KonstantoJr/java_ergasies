package gui;

import javax.swing.*;

import audio.GameAudioPlayer;
import filelist.Audio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import spaceships.*;


public class GamePlayScreen extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private final Set<Integer> pressedKeys = new HashSet<>();
	private Spaceship userSpaceShip;
	private SpaceshipEnemy enemySpaceShip;
	private Timer timer;
	private long lastFire = 0;
	private long fireRate = 500;
	private File sound;
	GamePlayScreen() {
		File[] audio = Audio.getWav();
		for (int i = 0; i < audio.length; i++) {
			if(audio[i].getName().equals("Laser_Gun_Sound.wav")){
				sound = audio[i];
			}
		}
		addKeyListener(this);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
	}
	public void createDaemon() {
		fireRate = userSpaceShip.getFireRate();
		this.timer = new Timer(100 , new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!pressedKeys.isEmpty()) {
					for (Iterator<Integer> it = pressedKeys.iterator();it.hasNext();) {
						switch(it.next()) {
						case KeyEvent.VK_UP:
							userSpaceShip.moveUp();
							break;
						case KeyEvent.VK_DOWN: 
							userSpaceShip.moveDown();
							break;
						case KeyEvent.VK_LEFT: 
							userSpaceShip.moveLeft();
							break;
						case KeyEvent.VK_RIGHT: 
							userSpaceShip.moveRight();
							break;
						case KeyEvent.VK_SPACE: 
							long time = System.currentTimeMillis();
							if (time > lastFire + fireRate) {
								GameAudioPlayer.playSound(sound);
								userSpaceShip.gun.fire(userSpaceShip.getX(), userSpaceShip.getY());
								lastFire = time;
							}
							break;
						}
					}
				}
				repaint();
			}
		});
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		enemySpaceShip.huntUserSpaceShip(userSpaceShip);
		userSpaceShip.getIcon().paintIcon(this, g, userSpaceShip.getX(),userSpaceShip.getY());
		enemySpaceShip.getIcon().paintIcon(this, g, enemySpaceShip.getX(), enemySpaceShip.getY());
		showLaserShootings(g);
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressedKeys.add(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_B) {
					this.timer.stop();
					SpaceFrame.cardLayout.show(this.getParent(), "selection");
					SpaceFrame.spaceshipSelection.requestFocusInWindow();
				}
		
	} 


	@Override public void keyReleased(KeyEvent e) {
		pressedKeys.remove(e.getKeyCode());
	}
	@Override public void keyTyped(KeyEvent arg0) {} 
	public void setUserSpaceShip(Spaceship usel) {
		userSpaceShip = usel;
	}
	public void setEnemySpaceShip(SpaceshipEnemy enemy) {
		enemySpaceShip = enemy;
	}
	private void showLaserShootings(Graphics g) {
		userSpaceShip.gun.laserShootersLinkedList.forEach((tmp)->{
			g.setColor(userSpaceShip.gun.lasercolor);
			g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y-15);
			tmp.y = tmp.y - 15;
		});
		enemySpaceShip.gun.laserShootersLinkedList.forEach((tmp)->{
			g.setColor(enemySpaceShip.gun.lasercolor);
			g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y-15);
			tmp.y = tmp.y + 15;
		});
	}
	

}

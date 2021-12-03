package spaceships;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import spaceships_laserguns.Lasergun;
import main.MainClass;

public class Spaceship implements Navigation{
	public Lasergun gun;
	protected static int cosmosWidth = MainClass.cosmosWidth;
	protected static int cosmosHeight = MainClass.cosmosHeight;
	protected static int spaceShipWidth = MainClass.spaceShipWidth;
	protected static int spaceShipHeight = MainClass.spaceShipHeight;
	protected static int yOffSet = MainClass.yOffset;
	private long fireRate;
	private int xCoords;
	private int yCoords;
	private File icon;
	private final String name;
	private final int movement;
	public Spaceship(int movement , String name , Color color , long fireRate) {
		this.movement = movement;
		this.name = name;
		this.xCoords = 0;
		this.yCoords = cosmosHeight - spaceShipHeight - yOffSet;
		this.gun = new Lasergun(color);
		this.fireRate = fireRate;
	}
	public Spaceship(int movement , String name , Color color, int x , int y) {
		this.movement = movement;
		this.name = name;
		this.xCoords = x;
		this.yCoords = y;
		this.gun = new Lasergun(color);
	}
	@Override
	public int moveUp() {
		this.yCoords = this.yCoords - this.movement;
		if (this.yCoords < 0) this.yCoords = this.yCoords + this.movement;
		return this.yCoords;
	}

	@Override
	public int moveDown() {
		this.yCoords = this.yCoords + this.movement;
		if (this.yCoords + spaceShipHeight + yOffSet > cosmosHeight) this.yCoords = this.yCoords - this.movement;
		
		return this.yCoords;
	}

	@Override
	public int moveLeft() {
		this.xCoords = this.xCoords - this.movement;
		if (this.xCoords < 0) this.xCoords = this.xCoords + this.movement;
		return this.xCoords;
	}

	@Override
	public int moveRight() {
		this.xCoords = this.xCoords + this.movement;
		if (this.xCoords + spaceShipWidth > cosmosWidth) this.xCoords = this.xCoords - this.movement;
		return this.xCoords;
	}
	public int getX() {
		return this.xCoords;
	}

	public int getY() {
		return this.yCoords;
	}

	public void setIcon(File sprite) {
		this.icon = sprite;
	}

	public ImageIcon getIcon() {
		Image sprite = null;
		try {
			sprite = ImageIO.read(this.icon);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		ImageIcon my_icon = new ImageIcon(sprite);
		return my_icon;
	}
	
	public void printCoords() {
		System.out.println(this.name +" Xcoords:"+this.xCoords+" Ycoords:"+this.yCoords );
	}
	
	public void fire(int x , int y) {
		this.gun.fire(x, y);
	}
	public long getFireRate() {
		return fireRate;
	}
}

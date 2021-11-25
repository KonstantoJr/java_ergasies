package spaceships;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Spaceship implements Navigation {

	protected static int cosmosWidth = 800;
	protected static int cosmosHeight = 580;
	protected static int spaceShipWidth = 100;
	protected static int spaceShipHeight = 100;
	private File icon;
	private final int movement;
	private int xCoords = 0;
	private int yCoords = 480;
	private final String name;

	public Spaceship(int movement, String name, int x, int y) {
		this.movement = movement;
		this.name = name;
		this.xCoords = x;
		this.yCoords = y;
	}

	@Override
	public int moveUp() {
		this.yCoords = this.yCoords - this.movement;
		if (this.yCoords < 0)
			this.yCoords = this.yCoords + this.movement;
		return this.yCoords;
	}

	@Override
	public int moveDown() {
		this.yCoords = this.yCoords + this.movement;
		if (this.yCoords + spaceShipHeight > cosmosHeight)
			this.yCoords = this.yCoords - this.movement;

		return this.yCoords;
	}

	@Override
	public int moveLeft() {
		this.xCoords = this.xCoords - this.movement;
		if (this.xCoords < 0)
			this.xCoords = this.xCoords + this.movement;
		return this.xCoords;
	}

	@Override
	public int moveRight() {
		this.xCoords = this.xCoords + this.movement;
		if (this.xCoords + spaceShipWidth > cosmosWidth)
			this.xCoords = this.xCoords - this.movement;
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
		System.out.println(this.name + " Xcoords:" + this.xCoords + " Ycoords:" + this.yCoords);
	}

}

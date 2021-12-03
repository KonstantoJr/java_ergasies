package spaceships;

import java.awt.Color;
import java.util.Random;

import main.MainClass;

public class SpaceshipEnemy extends Spaceship{
	static Random random = new Random();
	public SpaceshipEnemy() {
		super(15, "Enemy" , Color.RED, 0 , 0);
		
	}
	public void huntUserSpaceShip(Spaceship user) {
		int mv = random.nextInt(10);
		if (mv == 0) {
			this.gun.fire(this.getX() , this.getY());
		}
		if(user.getX()>this.getX()) this.moveRight();
		else this.moveLeft();
		
		int res = random.nextInt(4);
		if (res == 1) this.moveRight();
		else if (res == 3)this.moveLeft();
		int fire = random.nextInt(10);
		if (fire == 1)this.fire(this.getX(), this.getY() + MainClass.spaceShipHeight);
		/*
		int height = random.nextInt(10);
		if(height == 0 || height == 9) this.moveDown();
		else if (height == 1 || height == 8)this.moveUp();*/
	}

}

package spaceships_laserguns;

import main.MainClass;

public class Laser {
	public int x;
	public int y;
	public Laser(int x, int y){
		this.x = x + MainClass.spaceShipWidth/2;
		this.y = y;
	}
}

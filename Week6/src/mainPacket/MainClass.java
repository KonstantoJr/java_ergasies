package mainPacket;
import spaceships.*;
import java.util.LinkedList;
import java.util.Scanner;
public class MainClass {
	public static void main(String[] args) {
		LinkedList<Spaceship> spaceshiplist = new LinkedList<Spaceship>();
		Spaceship z = new SpaceshipZero();
		Spaceship a = new SpaceshipAlpha();
		Spaceship b = new SpaceshipBeta();
		Spaceship g = new SpaceshipGama();
		Spaceship d = new SpaceshipDelta();
		Spaceship e = new SpaceshipEnemy();
		
		spaceshiplist.add(z);
		spaceshiplist.add(a);
		spaceshiplist.add(b);
		spaceshiplist.add(g);
		spaceshiplist.add(d);
		spaceshiplist.add(e);
		
		System.out.println("Enter command to test spaceships movements:");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s1 = sc.next();
			System.out.println(s1);
			int i = 0 ;
			while (i<spaceshiplist.size()) {
				if (s1.equals("u")) spaceshiplist.get(i).moveUp();
				if (s1.equals("d")) spaceshiplist.get(i).moveDown();
				if (s1.equals("l")) spaceshiplist.get(i).moveLeft();
				if (s1.equals("r")) spaceshiplist.get(i).moveRight();
				spaceshiplist.get(i).printCoords();
				i++;
			}
		}
		sc.close();
	}

}

package main;
import audio.GameAudioPlayer;
import gui.*;

public class MainClass {
	public static SpaceFrame myShootingGame;
	public static GameAudioPlayer myAudio;
	public static int cosmosWidth = 800;
	public static int cosmosHeight = 600;
	public static int spaceShipWidth = 100;
	public static int spaceShipHeight = 100;
	public static int yOffset = 30;

	public static void main(String[] args) {
		myAudio = new GameAudioPlayer();
		myShootingGame = new SpaceFrame(cosmosWidth, cosmosHeight);
	}
}

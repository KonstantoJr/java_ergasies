package audio;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import filelist.Audio;

public class GameAudioPlayer {
	public static synchronized void playSound(File sound) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        final Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(sound);
		        clip.open(inputStream);
		        clip.start(); 
		        clip.addLineListener(new LineListener() {
		        	public void update(LineEvent e) {
		        		if(e.getType() == LineEvent.Type.STOP) {
		        			clip.close();
		        		}
		        	}
		        });
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	private AudioInputStream audioInputStream;
	private File space_ambience;
	Clip clip;
	public GameAudioPlayer() {
		File[] audio = Audio.getWav();
		for(int i =0 ; i<audio.length ; i++) {
			if(audio[i].getName().equals("space-ambience.wav")) {
				space_ambience = audio[i];
				loadSpaceAmbient();
			}
		}
	}
	void loadSpaceAmbient() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(space_ambience);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			FloatControl gainControl = 
					(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f);
			clip.start();
		}
	catch (Exception ex) { System.out.println(ex);}
	}
}

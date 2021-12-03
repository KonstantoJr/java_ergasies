package filelist;

import java.io.File;

public class Audio {
	public static File[] getWav() {
		File folder = new File("Resources/audio/");
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
		    }
}

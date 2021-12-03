package filelist;

import java.io.File;

public class Images {
	public static File[] getImages() {
		File folder = new File("Resources/images/");
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
		    }
		}

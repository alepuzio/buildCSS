package net.alepuzio.buildCSS.directory;

import java.io.File;
import java.io.FileFilter;

public class Physical_to_move  {

	public final File root;
	
	public Physical_to_move(String newRoot, String directory){
		this.root = new File(newRoot.concat("\\").concat(directory));
	}
	
	public File[] files(final String extension) {
		File[] templates = this.root.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(extension);
			}
		});
		return templates ;
	}


}


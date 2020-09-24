package net.alepuzio.buildCSS.directory;

import java.io.File;
import java.io.FileFilter;

public class Physical_to_move  {

	public final File root;
	
	Physical_to_move(String newRoot){
		this.root = new File(newRoot);
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


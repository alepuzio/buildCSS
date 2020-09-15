package net.alepuzio.physical;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class DirectoryInput implements Directory{

	public final File directory;
	
	public DirectoryInput(File newDirectory){
		this.directory = newDirectory;
	}
	
	/**
	 * @return array of <i>Files</i>, with termination <i>.properties</i>, that have the code CSS to insert
	 * */
	public File[] loadAllTemplates() throws IOException {
		File[] templates = this.directory.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				final String typeProperties = EnumFileSystem.PROPERTIES.name().toLowerCase();
				return pathname.getName().endsWith(typeProperties);
			}
		});
		return templates ;
	}

}

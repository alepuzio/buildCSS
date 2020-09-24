package net.alepuzio.physical;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.file.type.TemplateCSS;


public class DirectoryInput_da_buttare implements Directory{

	public final File directory;
	
	public DirectoryInput_da_buttare(File newDirectory){
		this.directory = newDirectory;
	}
	
	/**
	 * @return array of <i>Files</i>, with termination <i>.properties</i>, that have the code CSS to insert
	 * */
	public List<TemplateCSS> templateCSS() throws IOException {
		File[] templates = this.directory.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				final String extensionProperties = EnumFileSystem.PROPERTIES.name().toLowerCase();
				return pathname.getName().endsWith(extensionProperties);
			}
		});
		List<TemplateCSS> result = new ArrayList<TemplateCSS>();
		for (File tmp : templates){
			result.add(new TemplateCSS(tmp));
		}
		return result ;
	}

}

s
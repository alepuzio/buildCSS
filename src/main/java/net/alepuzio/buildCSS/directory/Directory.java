package net.alepuzio.buildCSS.directory;

import java.util.List;

import net.alepuzio.buildCSS.file.Template;

public interface Directory {
	
	/**
	 * @return list of file 
	 * */
	public List<Template> files(final String extension) ;
}

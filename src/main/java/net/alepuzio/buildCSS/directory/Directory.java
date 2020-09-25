package net.alepuzio.buildCSS.directory;

import java.util.List;

import net.alepuzio.buildCSS.file.InputFile;

public interface Directory {
	
	/**
	 * @return list of file 
	 * */
	public List<InputFile> files(final String extension) ;
}

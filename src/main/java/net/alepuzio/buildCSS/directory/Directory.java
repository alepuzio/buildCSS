package net.alepuzio.buildCSS.directory;

import java.util.List;

import net.alepuzio.buildCSS.file.FileData;

public interface Directory {
	
	/**
	 * @return list of code in the read files 
	 * */
	public List<? extends FileData > files() ;
}

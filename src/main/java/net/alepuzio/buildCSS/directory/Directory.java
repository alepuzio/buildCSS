package net.alepuzio.buildCSS.directory;

import java.util.List;

import net.alepuzio.buildCSS.file.Code;

public interface Directory {
	
	/**
	 * @return list of code in the read files 
	 * */
	public List<Code> files() ;
}

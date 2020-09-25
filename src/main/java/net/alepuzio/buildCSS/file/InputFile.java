package net.alepuzio.buildCSS.file;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;
/**
 * @overview: it manages the input files
 * */
public interface InputFile {

	public List<RowCodeCSS> code() throws IOException;
	public Properties data() ;
	/**
	 * @return title of the file
	 * */
	public String title();


}

package net.alepuzio.buildCSS.file;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;
/**
 * @overview: it manages the input files
 * */
public interface Code {

	/**
	 * @return the properties in a single file
	 * @deprecated move IOException
	 * */
	public List<RowCodeCSS> css() throws IOException;
	/**
	 * @return the properties in a single file
	 * */
	public Properties properties() ;
	/**
	 * @return title of the file
	 * */
	public String title();


}

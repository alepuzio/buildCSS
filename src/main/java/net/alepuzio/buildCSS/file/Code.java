package net.alepuzio.buildCSS.file;

import java.util.List;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;
/**
 * @overview: it manages the input files
 * */
public interface Code extends FileData {

	/**
	 * @return the properties in a single file
	 * */
	public List<RowCodeCSS> css() throws Exception;

}

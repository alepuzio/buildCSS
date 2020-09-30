package net.alepuzio.buildCSS.file;

import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;

public interface Nameplate extends FileData {

	/**
	 * @return the properties in a single file
	 * */
	public DecodedCSSInstruction properties() throws Exception ;

}

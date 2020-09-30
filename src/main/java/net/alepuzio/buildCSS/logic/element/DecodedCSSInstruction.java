package net.alepuzio.buildCSS.logic.element;

/***
 * @overview this interface declare the mapping between
 * nameplates and CSS code in properties
 */
public interface DecodedCSSInstruction {
	
	/**
	 *@return string of the CSS code to use
	 *@param key nameplate 
	 * */
	public String value(String key);
}

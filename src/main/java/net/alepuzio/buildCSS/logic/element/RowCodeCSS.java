package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;
import java.util.Set;

import net.alepuzio.buildCSS.enumeration.EnumCSSKey;
import net.alepuzio.buildCSS.enumeration.EnumKey;
/**
 * @overview: This class represents a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	public final String value;
	
	public RowCodeCSS substitutes(Properties newProperties) {
		String newValue = this.value;
		Set<Object> keys = newProperties.keySet();
		for  (Object singleKey: keys){
			newValue = substitute(newValue, singleKey.toString(), newProperties).value;
		}
		return new RowCodeCSS(newValue);
	}
	
	/**
	 * @return true if currentLine has at least one key in properties file
	 * @param currentLine: read line 
	 * */
	public boolean currentLineHasAtLeastOneKeyword() {
		return value.contains(EnumKey.FIRST.name())
				|| value.contains(EnumKey.SECOND.name())
				|| value.contains(EnumKey.THIRD.name()) 
				|| value.contains(EnumKey.FOURTH.name());
	}
	
	protected RowCodeCSS(String newValue){
		this.value  = newValue;
	}

	/************* PRIVATE METHODS ****************/
	
	private  RowCodeCSS substitute(String valueToChange, String key, Properties currentProperties) {
		String replacement = new StringBuilder(EnumCSSKey.SHARP.getValue()).append( currentProperties.getProperty(key)).toString();
		return new RowCodeCSS(valueToChange.replaceAll(key, replacement));
	}
}

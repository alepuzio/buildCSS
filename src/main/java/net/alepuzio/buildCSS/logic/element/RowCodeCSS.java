package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;
import java.util.Set;

import net.alepuzio.buildCSS.enumeration.EnumCSSKey;
/**
 * @overview: This class represent a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	private String value;
	

	public String getValue() {
		return this.value;
	}
	
	public RowCodeCSS substitutes(Properties newProperties) {
		String newValue = getValue();
		Set<Object> keys = newProperties.keySet();
		for  (Object singleKey: keys){
			newValue = substitute(newValue, singleKey.toString(), newProperties).getValue();
		}
		return new RowCodeCSS(newValue);
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

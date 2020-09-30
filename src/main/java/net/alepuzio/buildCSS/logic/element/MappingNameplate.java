package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;

/**
* @overview : it manage the operations on the properties
*/
public class MappingNameplate implements DecodedCSSInstruction {

	
	public final Properties currentProperties;

	public MappingNameplate(Properties currentProperties) {
		this.currentProperties = currentProperties;
	}
	
	public String value(String key){
		return currentProperties.getProperty(key);
	}
	
	
}




	
	
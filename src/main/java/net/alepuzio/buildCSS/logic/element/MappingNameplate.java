package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;


public class MappingNameplate implements Mapping {

	
	public final Properties currentProperties;

	public MappingNameplate(Properties currentProperties) {
		this.currentProperties = currentProperties;
	}
	
	public String value(String key){
		return currentProperties.getProperty(key);
	}
	
	
}




	
	
package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;

import net.alepuzio.buildCSS.enumeration.EnumCSSKey;



public class MappingNameplate implements Mapping {

	
	public final Properties currentProperties;

	public MappingNameplate(Properties currentProperties) {
		this.currentProperties = currentProperties;
	}
	
	public String value(String key){
		return currentProperties.getProperty(key);
	}
	
	
}


class FinalCSSRow  implements Mapping {
	public final MappingNameplate origin;
	public final String key;
	
	FinalCSSRow(MappingNameplate newOrigin, String newKey){
		this.origin = newOrigin; 
		this.key = newKey;
	}
	
	public String value(String key){
		return EnumCSSKey.SHARP.getValue() + this.origin.value(this.key);
	}
	
	
	public  RowCodeCSS substitute(String valueToChange) {
		return new RowCodeCSS(valueToChange.replaceAll(key,this.value(key)));
	}
	
}

	
	
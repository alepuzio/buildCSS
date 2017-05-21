package net.alepuzio.buildCSS;

import java.util.Properties;
import java.util.Set;

public class RowCodeCSS {
	
	private String value;
	
	public final static RowCodeCSS instance(String newValue){
		return new RowCodeCSS(newValue);
	}
	
	public static RowCodeCSS instanceEmpty( ) {
		return new RowCodeCSS("\n") ;
	}

	public String getValue() {
		return value;
	}
	
	public RowCodeCSS substitutes(Properties newProperties) {
		String newValue = getValue();
		Set<Object> keys = newProperties.keySet();
		for  (Object singleKey: keys){
			newValue = substitute(newValue, singleKey.toString(), newProperties).getValue();
		}
		return new RowCodeCSS(newValue);
	}
	
	/************* PRIVATE METHODS ****************/
	
	private RowCodeCSS(String newValue){
		this.value  = newValue;
	}

	
	private  RowCodeCSS substitute(String valueToChange, String key, Properties currentProperties) {
		String replacement = new StringBuilder("#").append( currentProperties.getProperty(key)).toString();
		return new RowCodeCSS(valueToChange.replaceAll(key, replacement));
	}
}

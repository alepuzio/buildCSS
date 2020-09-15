package net.alepuzio.buildCSS.logic.element.row;

import java.util.Properties;
import java.util.Set;

import net.alepuzio.buildCSS.logic.element.MappingNameplate;


/**
 * @overview: This class represents a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	public final String value;
	/**
	 * @return a new RowCodeCSS , after substitute the constant FIRST, SECOND, etc
	 * */
	public RowCodeCSS finalCSS(Properties newProperties) {
		String newValue = this.value;
		Set<Object> keys = newProperties.keySet();
		for  (Object singleKey: keys){
			newValue = new MappingNameplate(newProperties).value((String)singleKey);
		}
		return new RowCodeCSS(newValue);
	}
	
	/**
	 * @return true if currentLine has at least one key in properties file
	 * @param currentLine: read line 
	 * */
	public boolean hasOnePlatename() {
		return value.contains(EnumKey.FIRST.name())
				|| value.contains(EnumKey.SECOND.name())
				|| value.contains(EnumKey.THIRD.name()) 
				|| value.contains(EnumKey.FOURTH.name());
		//new 	ArrayList<EnumKey>(EnumKey.values()).contains(value); TODO is it possible?
	}
	
	RowCodeCSS(String newValue){
		this.value  = newValue;
	}

	
}

/**
 * @overview: Enumeration of the CSS nameplates
 * */
 enum EnumKey {
	FIRST,
	SECOND,
	THIRD,
	FOURTH
	
	;

}

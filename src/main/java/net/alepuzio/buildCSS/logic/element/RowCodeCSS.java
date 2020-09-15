package net.alepuzio.buildCSS.logic.element;

import java.util.Properties;
import java.util.Set;

import net.alepuzio.buildCSS.enumeration.EnumCSSKey;
/**
 * @overview: This class represents a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	public final String value;
	public final Mapping mappingNameplate;
	/**
	 * @return a new RowCodeCSS , after substitute the constant FIRST, SECOND, etc
	 * */
	public RowCodeCSS substitutes(Properties newProperties) {
		String newValue = this.value;
		Set<Object> keys = newProperties.keySet();
		for  (Object singleKey: keys){
			newValue = this.mappingNameplate.value((String)singleKey);
		}
		return newValue;
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
	
	protected RowCodeCSS(String newValue, Properties currentProperties){
		this.value  = newValue;
		this.mappingNameplate = new MappingNameplate(currentProperties);
	}

	
}

package net.alepuzio.buildCSS.file;

import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;
import net.alepuzio.buildCSS.logic.element.MappingNameplate;

public class Factory {
	public final String param;
	
	public Factory(String newParam){
		this.param = newParam;
	}

	public Nameplate file(){
		Nameplate result = null;
		if ("fake".equals(this.param)){//TODO decorator
			result = new Fake();
		} else{
			new IllegalArgumentException(
					String.format("The value -{0}- is not expected", this.param)
					);
		}
		return result;
	}
}

class Fake implements Nameplate {


	public DecodedCSSInstruction properties() {
		Properties properties = new Properties();
		properties.put("FIRST","1");
		return  new MappingNameplate(properties);
	}

	public String title() {
		return "title_fake";
	}

}

package net.alepuzio.buildCSS.enumeration;

public class NoFile implements Message{

	public String getValue() {
		return "Null instance of configuration file";
	}

	public boolean notNull() {
		return false;
	}	
	
}


package net.alepuzio.buildCSS.logging.message;

public class NoFile implements Message{

	public String getValue() {
		return "Null instance of configuration file";
	}

	public boolean notNull() {
		return false;
	}	
	
}

ss
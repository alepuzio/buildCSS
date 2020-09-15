package net.alepuzio.buildCSS.logging.message;

public class NoConfig implements Message{
	public String getValue() {
		return "Absent configuration file.";
	}

	public boolean notNull() {
		return true;
	}

}

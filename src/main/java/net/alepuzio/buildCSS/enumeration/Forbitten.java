package net.alepuzio.buildCSS.enumeration;

public class Forbitten implements Message{

	public String getValue() {
		return "Yout don\'t have the read permission";
	}

	public boolean notNull() {
		return true;
	}
}
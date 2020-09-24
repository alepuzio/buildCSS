package net.alepuzio.buildCSS.logging.message;

class Forbitten implements Message {

	public String getValue() {
		return "Yout don\'t have the read permission";
	}

	public boolean notNull() {
		return true;
	}
}

class NoConfig implements Message{
	public String getValue() {
		return "Absent configuration file.";
	}

	public boolean notNull() {
		return true;
	}

}

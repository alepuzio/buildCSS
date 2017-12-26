package net.alepuzio.buildCSS.enumeration;

public enum EnumMessages {
	
	WRONG_ARGUMENTS("Absent configuration file."),
	UNDEFINED_MODEL("Undefined model:"),
	NULL_INSTANCE("Null instance of configuration file"),
	UNDEFINED_CSS_MODEL("Undefined CSS model:"),
	FORBITTEN_FILE("Don't have the read permission");
	;
	
	private String value;
	
	private EnumMessages(String newValue) {
		this.value = newValue;
	}
	
	public String getValue(){
		return this.value;
	}
}

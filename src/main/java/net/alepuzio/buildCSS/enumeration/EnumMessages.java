package net.alepuzio.buildCSS.enumeration;

public enum EnumMessages {
	
	WRONG_ARGUMENTS("Wrong arguments: it need only the name of CSS template."),
	UNDEFINED_MODEL("Undefined model:"),
	WRONG_ARGUMENTS_PATH("Wrong arguments: it need only the path of configuration's file."),
	NULL_INSTANCE("Null instance"),
	UNDEFINED_CSS_MODEL("Undefined CSS model:"),
	FORBITTEN_FILE("Don't have read permission");
	;
	
	private String value;
	
	private EnumMessages(String newValue) {
		this.value = newValue;
	}
	
	public String getValue(){
		return this.value;
	}
}

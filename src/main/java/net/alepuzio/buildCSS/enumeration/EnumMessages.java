package net.alepuzio.buildCSS.enumeration;

public enum EnumMessages {
	
	WRONG_ARGUMENTS("Wrong arguments: it need only the name of CSS template."),
	BEGIN_PROGRAM("Begin"),
	END_PROGRAM("Successfull creation of themes"),
	UNDEFINED_MODEL("Undefined model:"),
	WRONG_ARGUMENTS_PATH("Wrong arguments: it need only the path of configuration's file."),
	NULL_INSTANCE("Null instance"),
	Undefined_CSS_model("Undefined CSS model:"),
	;
	
	private String value;
	
	private EnumMessages(String newValue) {
		this.value = newValue;
	}
	
	public String getValue(){
		return this.value;
	}
}

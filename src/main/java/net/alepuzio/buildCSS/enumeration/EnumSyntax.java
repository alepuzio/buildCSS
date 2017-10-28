package net.alepuzio.buildCSS.enumeration;

public enum EnumSyntax {
	CR("\n"),
	SEPARATOR("\\"),
	CSS(".css"),
	;
	
	private String value;
	
	private EnumSyntax(String newValue) {
		this.value = newValue;
	}
	
	public String getValue(){
		return this.value;
	}
}

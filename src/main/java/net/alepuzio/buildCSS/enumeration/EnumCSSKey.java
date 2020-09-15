package net.alepuzio.buildCSS.enumeration;

public enum EnumCSSKey {//TODO keep in mind advantages

	SHARP("#")
	;
	
	private String value;
	
	private EnumCSSKey(String newValue) {
		this.value = newValue;
	}
	
	public String getValue(){
		return this.value;
	}
	
}


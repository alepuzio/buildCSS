package net.alepuzio.buildCSS.logic.element;

import net.alepuzio.buildCSS.enumeration.EnumSyntax;

public class FactoryRowCSS {
	
	private String newValue = null;
	
	public FactoryRowCSS(String newValue) {
		super();
		this.newValue = newValue;
	}
	

	public String getNewValue() {
		return this.newValue;
	}

	public final RowCodeCSS instance(){
		return new RowCodeCSS(getNewValue());
	}
	
	public  RowCodeCSS instanceEmpty() {
		return new RowCodeCSS(EnumSyntax.CR.getValue()) ;
	}

}

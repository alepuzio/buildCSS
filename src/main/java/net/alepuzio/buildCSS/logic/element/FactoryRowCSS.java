package net.alepuzio.buildCSS.logic.element;

/**
 * @overview: this class builds a CSS row of the final files*/
public class FactoryRowCSS {
	
	public final String newValue;
	
	public FactoryRowCSS(String newValue) {
		this.newValue = newValue;
	}
	
	public final RowCodeCSS instance(){
		return new RowCodeCSS(this.newValue);
	}
	
	//TODO read yegor
	public  RowCodeCSS instanceEmpty() {
		return new RowCodeCSS("\n") ;
	}

}

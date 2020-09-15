package net.alepuzio.buildCSS.logic.element.row;

import net.alepuzio.buildCSS.logic.element.RowCodeCSS;

/**
 * @overview class that manage a single row as CSS instruction
 * */
public class FactoryRowCSS {

	public final String currentLine;
	
	public FactoryRowCSS(String current){
		this.currentLine = current;
	}
	
	public RowCodeCSS instance(){
		return new RowCodeCSS(this.currentLine);
	}
	
	public RowCodeCSS finalCSS(){
		return new RowCodeCSS(this.currentLine);
	}
	
}

package net.alepuzio.physical;

import java.io.IOException;
import java.util.List;

import net.alepuzio.buildCSS.logic.element.RowCodeCSS;

public interface IDIrectoryOutput {
	public void createsCSSThemesFromDirectory() throws IOException ;
	public StringBuilder createFileCSS() ;
	public void writeSingleCSSTheme(List<RowCodeCSS> rows) throws IOException ;


}

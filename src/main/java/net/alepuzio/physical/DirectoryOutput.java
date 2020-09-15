package net.alepuzio.physical;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.RowCodeCSS;

public class DirectoryOutput implements IDIrectoryOutput {
	
	public final File value;
	
	
	DirectoryOutput(File newValue){
		this.value = newValue;
	}
	/**
	 * @return name of CSS file to create
	 * */
	public StringBuilder createFileCSS() {
		return new StringBuilder(value.getAbsolutePath()).append(
				"\\").append(nameTemplate()).append(".css");
	}
	
	/**
	 * @effects: Build physical CSS files
	 * */
	public void createsCSSThemesFromDirectory() throws IOException {
		File[] templates = new DirectoryInput(null).loadAllTemplates();
		DirectoryOutput output = new DirectoryOutput(null);
		new DevelopmentUtilActive("createsCSSThemesFromDirectory").printMsgDebug();
		for(File singleTemplate : templates){
			new DevelopmentUtilActive("loadSingleTemplate(" + singleTemplate + ");").printMsgDebug();
			new NameTemplate(singleTemplate).load();
			List<RowCodeCSS> cssCode = new PathDesktopModelCSS(null).useTemplateOverModelCSS();
			output.writeSingleCSSTheme(cssCode);
		}
		
	}
	
	/**
	 * @param rows: list of CSS code modified and to print
	 * */
	public void writeSingleCSSTheme(List<RowCodeCSS> rows) throws IOException {
		StringBuilder fileThemeCSSOutput = createFileCSS();
		new DevelopmentUtilActive("fileThemeCSS:" + fileThemeCSSOutput.toString()).printMsgDebug();
		BufferedWriter newThemeCSSToWrite = null;
		try {
    		newThemeCSSToWrite = new BufferedWriter(new FileWriter(fileThemeCSSOutput.toString()));
			Iterator<RowCodeCSS> toWrite = rows.iterator();
			while(toWrite.hasNext()){
				newThemeCSSToWrite.write(toWrite.next().value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != newThemeCSSToWrite) {
				newThemeCSSToWrite.flush();
				newThemeCSSToWrite.close();
			}
		}
	}


}

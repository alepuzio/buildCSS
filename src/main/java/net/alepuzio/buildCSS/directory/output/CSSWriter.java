package net.alepuzio.buildCSS.directory.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import net.alepuzio.buildCSS.file.InputFile;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class CSSWriter {
	
	//public final List<RowCodeCSS> rows;
	//public final String title;
	
	public final  InputFile origin;
	
//	public CSSWriter(String newTitle, List<RowCodeCSS> newRows){
//		this.origin;
//		this.title = newTitle;
//	}
	public CSSWriter(InputFile newOrigin){
		this.origin = newOrigin;
	}
	
	/**
	 * @param rows: list of CSS code modified and to print
	 * */
	public void writeSingleCSSTheme() throws IOException {
		BufferedWriter newThemeCSSToWrite = null;
		try {
    		newThemeCSSToWrite = new BufferedWriter(new FileWriter(this.origin.title()));
			Iterator<RowCodeCSS> toWrite = this.origin.code().iterator();
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

package net.alepuzio.buildCSS.directory.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class CSSWriter {
	
	public final List<RowCodeCSS> rows;
	public final String title;
	
	CSSWriter(String newTitle, List<RowCodeCSS> newRows){
		this.rows = newRows;
		this.title = newTitle;
	}
	
	/**
	 * @param rows: list of CSS code modified and to print
	 * */
	public void writeSingleCSSTheme(List<RowCodeCSS> rows) throws IOException {
		BufferedWriter newThemeCSSToWrite = null;
		try {
    		newThemeCSSToWrite = new BufferedWriter(new FileWriter(this.title));
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

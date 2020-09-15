package net.alepuzio.buildCSS.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.row.FactoryRowCSS;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;


/**
 * @overview: file CSS
 * */
public class TemplateCSS{
	
	public final File file;
	
	public TemplateCSS(File newFile){
		this.file = newFile;
	}	

	public BufferedReader initialCodeCSS() throws FileNotFoundException{
		return new BufferedReader(new FileReader(this.file.getAbsoluteFile()));
	}
	/**
	 * @return CSS code modified
	 * */
	public List<RowCodeCSS> useTemplateOverModelCSS() throws IOException {
		new DevelopmentUtilActive("useTemplateOverModelCSS();").printMsgDebug();
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
 	   	BufferedReader templateCSSToRead = this.initialCodeCSS();
 	   	FactoryRowCSS factroy = new FactoryRowCSS(templateCSSProperties());
    	try {
			String currentLine = null;
			while (null != ( currentLine = templateCSSToRead.readLine())) {
				
				RowCodeCSS codeCSS = factroy.instance(currentLine);//TODO move in a class
				if (codeCSS.hasOnePlatename()) {//TODO using yegor decorator
					RowCodeCSS codeCSSSostituito = codeCSS.finalCSS(templateCSSProperties());
					finalCSS.add(codeCSSSostituito);
				} else {
					finalCSS.add(codeCSS);
				}
			}
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined CSS model:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != templateCSSToRead) {
				templateCSSToRead.close();
			}
		}
		return finalCSS;
	}

	
}

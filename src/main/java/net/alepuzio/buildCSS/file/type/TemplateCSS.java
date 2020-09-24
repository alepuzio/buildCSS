package net.alepuzio.buildCSS.file.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.alepuzio.buildCSS.file.Template;
import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.row.FactoryRowCSS;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;


/**
 * @overview: file CSS on memory
 * */
public class TemplateCSS implements Template {
	
	public final File file;
	
	public TemplateCSS(File newFile){
		this.file = newFile;
	}	
	/**
	 * @return CSS code modified
	 * */
	public List<RowCodeCSS> code() throws IOException {
		new DevelopmentUtilActive("useTemplateOverModelCSS();").printMsgDebug();
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
		Read fileCSS = null;
    	try {
    		fileCSS = new Read(this.file);
			String currentLine = null;
			while (null != ( currentLine = fileCSS.readLine())) {				
				RowCodeCSS codeCSS = new FactoryRowCSS(currentLine).instance();//TODO move in a class?
				finalCSS.add(codeCSS);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined CSS model:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileCSS.close();
		}
		return finalCSS;
	}
}

/**
 * @overview: it read a file line by line
 * */
class Read{
	final BufferedReader templateCSSToRead;
    
	Read(File newFileReader  ) throws FileNotFoundException{
		this.templateCSSToRead = new BufferedReader(new FileReader(newFileReader.getAbsoluteFile()));
	}
	
	String readLine() throws IOException{
		return this.templateCSSToRead.readLine();
	}
	
	void close() throws IOException{
		if (null != templateCSSToRead) {
			templateCSSToRead.close();
		}
	
	}
}

class Final implements Template {
	
	public final Template initialCSS;
	public final Template templateProperties;
	
	Final(Template newInitialCSS,Template newTemplateProperties){
		this.initialCSS = newInitialCSS;
		this.templateProperties = newTemplateProperties;
			
	}
	
	public List<RowCodeCSS> code()  throws IOException {
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
 	   	List<RowCodeCSS> initialCode = this.initialCSS.code();
		Iterator<RowCodeCSS> iteraRows = initialCode.iterator();
		while(iteraRows.hasNext()){
			RowCodeCSS finalRow = iteraRows.next().finalCSS(this.templateProperties);
			finalCSS.add(finalRow);
		}
		return finalCSS;
	}
	
}

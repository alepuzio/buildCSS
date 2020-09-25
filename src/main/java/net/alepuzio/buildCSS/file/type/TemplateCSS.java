package net.alepuzio.buildCSS.file.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.row.FactoryRowCSS;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;


/**
 * @overview: file CSS on memory
 * */
public class TemplateCSS implements Code {
	
	public final File file;
	
	public TemplateCSS(File newFile){
		this.file = newFile;
	}	
	/**
	 * @return CSS code modified
	 * */
	public List<RowCodeCSS> css() throws IOException {
		//new DevelopmentUtilActive("code();").printMsgDebug();
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

	public Properties properties() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String title(){
		int index = this.file.getName().indexOf(".css");
		return this.file.getName().substring(0, index);
	}

}

/**
 * @overview: it read a file line by line
 * */
class Read {
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


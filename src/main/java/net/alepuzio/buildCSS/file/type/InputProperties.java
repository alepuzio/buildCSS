package net.alepuzio.buildCSS.file.type;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.file.InputFile;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;


/**
 * @overview: file Proeprties
 * */
public class InputProperties implements InputFile {
	
	public final File file;
	
	public InputProperties(File newFile){
		this.file = newFile;
	}	
	/**
	 * @return CSS code modified
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public Properties data()  {
		Properties loader = new Properties();
		try {
			loader.load(new FileInputStream(this.file.getAbsoluteFile()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loader;
	}

	public List<RowCodeCSS> code() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

//TODO create cache class as yegor indicates in the book

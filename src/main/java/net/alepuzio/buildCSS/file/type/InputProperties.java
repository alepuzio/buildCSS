package net.alepuzio.buildCSS.file.type;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.alepuzio.buildCSS.file.Nameplate;
import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;
import net.alepuzio.buildCSS.logic.element.MappingNameplate;


/**
 * @overview: file Properties
 * */
public class InputProperties implements Nameplate {
	
	public final File file;
	
	public InputProperties(File newFile){
		this.file = newFile;
	}	
	/**
	 * @return CSS code modified
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public DecodedCSSInstruction properties() throws Exception {
		Properties loader = new Properties();
		try {
			loader.load(new FileInputStream(this.file.getAbsoluteFile()));
		} catch (Exception e) {
			throw new Exception(
					String.format("Error in reading file -{0]-",
							this.file.getAbsoluteFile().getAbsolutePath()
							),e);
		}
		return new MappingNameplate(loader);
	}

	public String title(){
		int index = this.file.getName().indexOf(".properties");
		return this.file.getName().substring(0, index);
	}
}

//TODO create cache class as yegor indicates in the book

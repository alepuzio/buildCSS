package net.alepuzio.physical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @overview name of the template css stylesheet
 * */
public class NameTemplate {

	public final  File fileInput ;
	
	NameTemplate(File newfileInput ){
		this.fileInput = newfileInput;
	}
	
	/**
	 * @param fileInput: file of the single CSS theme
	 * @throws IOException : exception in reading the properties file
	 * */
	public void load() throws IOException {
		templateCSSProperties().clear();
		templateCSSProperties().load(new BufferedReader(new FileReader(fileInput)));
		
	}

	public String nameTemplate(){
		String nameOfInputFile = fileInput.getName();
		int extensionProperties = nameOfInputFile.indexOf("." + EnumFileSystem.PROPERTIES.name().toLowerCase());//TODO concatenation
		return nameOfInputFile.substring(0, extensionProperties).toUpperCase();
	}

}

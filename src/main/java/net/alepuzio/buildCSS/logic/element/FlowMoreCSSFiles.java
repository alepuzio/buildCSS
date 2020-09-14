package net.alepuzio.buildCSS.logic.element;

//import java.io.BufferedReader; TODO move in physical
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileFilter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.enumeration.EnumFileSystem;
import net.alepuzio.buildCSS.enumeration.EnumKey;
import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
//import net.alepuzio.buildCSS.logging.DevelopmentUtil;
//import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
//import net.alepuzio.buildCSS.logging.DevelopmentUtilInactive;
import net.alepuzio.physical.Data;
import net.alepuzio.physical.DirectoryInput;
import net.alepuzio.physical.DirectoryOutput;
import net.alepuzio.physical.PathDesktopModelCSS;


/**
 * @overview: This class manages the process of building the set of CSS files 
 * */
public class FlowMoreCSSFiles /*implemements*/{
	
	//public final  File directoryInput;
	//public final  File directoryOutput;
	//public final  File pathModelCSS;
	//public final  Properties templateCSSProperties;
	
	public final Data source ;
	private final String nameTemplate;
	

	/**
	 * @constructor
	 */
	protected FlowMoreCSSFiles() {
		this.templateCSSProperties = new Properties();
	}

	

	
	/**
	 * @return initialized object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */	
	public FlowMoreCSSFiles init(File abc) {
		Properties propertiesEnvironment = new Properties();
		try {
			propertiesEnvironment.load(new BufferedReader(new FileReader(abc.getAbsolutePath())));
			//Data disk = new Data(new HardDisk()); TODO fix
			new DevelopmentUtilActive("toString: " + this.toString()).printMsgDebug();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
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
	

	
	
}

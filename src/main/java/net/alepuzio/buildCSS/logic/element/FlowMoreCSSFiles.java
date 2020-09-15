package net.alepuzio.buildCSS.logic.element;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.TemplateCSS;
import net.alepuzio.physical.DirectoryInput;
import net.alepuzio.physical.DirectoryOutput;
import net.alepuzio.physical.NameTemplate;
import net.alepuzio.physical.PathDesktopModelCSS;


/**
 * @overview: This class manages the process of building the set of CSS files 
 * - in the directory input, load the template of css 
 * */
public class FlowMoreCSSFiles /*implemements*/{
	
	public final File configurationFile;//TODO use Path
	

	/**
	 * @constructor
	 */
	protected FlowMoreCSSFiles(File newConfigurationFile) {
		this.configurationFile = newConfigurationFile;
	}

	/**
	 * @return the list of template CSS
	 * */
	public List<TemplateCSS> templateCSS() throws IOException{
		 return new DirectoryInput(configurationFile).templateCSS();
	}
	
	/**
	 * @effects: Write the physical CSS files after substitution
	 * */
	public void createsCSSThemesFromDirectory() throws IOException {
		new DevelopmentUtilActive("createsCSSThemesFromDirectory").printMsgDebug();
		DirectoryOutput output = new DirectoryOutput(null);
		for(File singleTemplate : templates){
			new DevelopmentUtilActive("loadSingleTemplate(" + singleTemplate + ");").printMsgDebug();
			new NameTemplate(singleTemplate).load();
			List<RowCodeCSS> cssCode = new PathDesktopModelCSS(null).useTemplateOverModelCSS();
			output.writeSingleCSSTheme(cssCode);
		}
		
	}

	
	
	
	
	

	
	
}

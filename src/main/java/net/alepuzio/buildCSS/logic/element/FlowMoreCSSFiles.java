package net.alepuzio.buildCSS.logic.element;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.enumeration.EnumFileSystem;
import net.alepuzio.buildCSS.enumeration.EnumKey;
import net.alepuzio.buildCSS.enumeration.EnumMessages;
import net.alepuzio.buildCSS.enumeration.EnumSyntax;
import net.alepuzio.buildCSS.logging.DevelopmentUtil;
import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logging.DevelopmentUtilInactive;


/**
 * @overview: This class manages the process of building the set of CSS files 
 * */
public class FlowMoreCSSFiles {
	
	private File directoryInput = null;
	private File directoryOutput = null;
	private File pathModelCSS = null;
	
	private String nameTemplate = null;
	private Properties templateCSSProperties = null;
	private boolean activeMessage = false;

	

	public File directoryInput() {
		return this.directoryInput;
	}

	public FlowMoreCSSFiles directoryInput(File directory) {
		this.directoryInput = directory;
		return this;
	}
	
	public Properties templateCSSProperties() {
		return this.templateCSSProperties;
	}

	public String nameTemplate() {
		return this.nameTemplate;
	}
	
	public FlowMoreCSSFiles nameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
		return this;
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
			final File input = new File(propertiesEnvironment.getProperty(EnumFileSystem.DIRECTORY_INPUT.name()));
			final File output = new File(propertiesEnvironment.getProperty(EnumFileSystem.DIRECTORY_OUTPUT.name()));
			final File pathModelCSS = new File(propertiesEnvironment.getProperty(EnumFileSystem.PATH_MODEL_CSS.name()));
			final boolean activeMessage = new Boolean(propertiesEnvironment.getProperty(EnumFileSystem.PATH_MODEL_CSS.name()));
			this.directoryInput(input).directoryOutput(output).pathModelCSS(pathModelCSS).showMessages(activeMessage);
			this.useDevelopmentUtil("toString: " + this.toString()).printMsgDebug();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * @effects: Build physical CSS files
	 * */
	public void createsCSSThemesFromDirectory() throws IOException {
		File[] templates = loadAllTemplates();
		this.useDevelopmentUtil("createsCSSThemesFromDirectory").printMsgDebug();
		for(File singleTemplate : templates){
			this.useDevelopmentUtil("loadSingleTemplate(" + singleTemplate + ");").printMsgDebug();
			loadSingleTemplate(singleTemplate);
			List<RowCodeCSS> cssCode = useTemplateOverModelCSS();
			writeSingleCSSTheme(cssCode);
		}
	}
	

	
	
	/**
	 * @return list of CSS code modified
	 * */
	private List<RowCodeCSS> useTemplateOverModelCSS() throws IOException {
		this.useDevelopmentUtil("useTemplateOverModelCSS();").printMsgDebug();
		List<RowCodeCSS> row = new ArrayList<RowCodeCSS>();
 	   	BufferedReader templateCSSToRead = null;
    		try {
			templateCSSToRead = new BufferedReader(new FileReader(this.pathModelCSS().getAbsoluteFile()));
			String currentLine = null;
			while (null != ( currentLine = templateCSSToRead.readLine())) {
				FactoryRowCSS factoryRowCSS = new FactoryRowCSS(currentLine);
				RowCodeCSS codeCSS = factoryRowCSS.instance();
				if (currentLineHasAtLeastOneKeyword(currentLine)) {
					RowCodeCSS codeCSSSostituito = codeCSS.substitutes(templateCSSProperties());
					row.add(codeCSSSostituito);
				} else {
					row.add(codeCSS);
				}
				row.add(factoryRowCSS.instanceEmpty());

			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(EnumMessages.UNDEFINED_CSS_MODEL.getValue() + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != templateCSSToRead) {
				templateCSSToRead.close();
			}
		}
		return row;
	}

	/**
	 * @return true if currentLine has at least one key in properties file
	 * @param currentLine: read line 
	 * */
	private boolean currentLineHasAtLeastOneKeyword(String currentLine) {
		return currentLine.contains(EnumKey.FIRST.name())||currentLine.contains(EnumKey.SECOND.name())||currentLine.contains(EnumKey.THIRD.name())||currentLine.contains(EnumKey.FOURTH.name());
	}
	
	/**
	 * @param rows: list of CSS code modified and to print
	 * */
	private void writeSingleCSSTheme(List<RowCodeCSS> rows) throws IOException {
		StringBuilder fileThemeCSSOutput = createFileCSS();
		this.useDevelopmentUtil("fileThemeCSS:" + fileThemeCSSOutput.toString()).printMsgDebug();
		BufferedWriter newThemeCSSToWrite = null;
		try {
    		newThemeCSSToWrite = new BufferedWriter(new FileWriter(fileThemeCSSOutput.toString()));
			Iterator<RowCodeCSS> toWrite = rows.iterator();
			while(toWrite.hasNext()){
				newThemeCSSToWrite.write(toWrite.next().getValue());
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

	/**
	 * @return name of CSS file to create
	 * */
	private StringBuilder createFileCSS() {
		return new StringBuilder(this.directoryOutput().getAbsolutePath()).append(EnumSyntax.SEPARATOR.getValue()).append(nameTemplate()).append(EnumSyntax.CSS.getValue());
	}

	
	/**
	 * @constructor
	 */
	protected FlowMoreCSSFiles() {
		this.templateCSSProperties = new Properties();
	}
	
	
	
	/**
	 * @return array of <i>Files</i>, with termination <i>.properties</i>, that have the code CSS to insert
	 * */
	private File[] loadAllTemplates() throws IOException {
		File[] templates = this.directoryInput().listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				final String typeProperties = EnumFileSystem.PROPERTIES.name().toLowerCase();
				return pathname.getName().endsWith(typeProperties);
			}
		});
		return templates ;
	}
	
	/**
	 * @param fileInput: file of the single CSS theme
	 * @throws IOException : exception in reading the properties file
	 * */
	private void loadSingleTemplate(File fileInput) throws IOException {
		templateCSSProperties().clear();
		templateCSSProperties().load(new BufferedReader(new FileReader(fileInput)));
		String nameOfInputFile = fileInput.getName();
		int extensionProperties = nameOfInputFile.indexOf("." + EnumFileSystem.PROPERTIES.name().toLowerCase());
		nameTemplate(nameOfInputFile.substring(0, extensionProperties).toUpperCase());
	}



	private File directoryOutput() {
		return this.directoryOutput;
	}

	private FlowMoreCSSFiles directoryOutput(File directoryOutput) {
		this.directoryOutput = directoryOutput;
		return this;
	}

	private File pathModelCSS() {
		return this.pathModelCSS;
	}

	private FlowMoreCSSFiles pathModelCSS(File pathModelCSS) {
		this.pathModelCSS = pathModelCSS;
		return this;
	}
	
	private FlowMoreCSSFiles showMessages(boolean pathModelCSS) {
		this.activeMessage = pathModelCSS;
		return this;
	}
	
	public DevelopmentUtil useDevelopmentUtil(String message) {
		DevelopmentUtil developmentUtil = null;
		if(this.isActiveMessage()) {
			 developmentUtil = new DevelopmentUtilActive(message);
		}else {
			 developmentUtil = new DevelopmentUtilInactive();
		}
		return developmentUtil;
	}
	
	
	@Override
	public String toString() {
		return "FlowMoreCSSFiles [directoryInput=" + this.directoryInput + ", directoryOutput=" +  this.directoryOutput
				+ ", pathModelCSS=" + this.pathModelCSS + ", nameTemplate=" +  this.nameTemplate + ", templateCSSProperties="
				+  this.templateCSSProperties + ", activeMessage="  + this.activeMessage + "]";
	}

	public boolean isActiveMessage() {
		return this.activeMessage;
	}


}

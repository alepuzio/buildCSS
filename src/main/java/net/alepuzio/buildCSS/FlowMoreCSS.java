package net.alepuzio.buildCSS;

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
/**
 * @overview: This class manages the process of building the set of CSS files 
 * */
public class FlowMoreCSS {
	
	private File configurationFile = null;
	private File directoryInput = null;
	private File directoryOutput = null;
	private File pathModelCSS = null;
	
	private String nameTemplate = null;
	private Properties templateCSSProperties = null;
	private static FlowMoreCSS instance = null;
	

	private File configurationFile() {
		return configurationFile;
	}


	private File directoryOutput() {
		return directoryOutput;
	}

	private FlowMoreCSS directoryOutput(File directoryOutput) {
		this.directoryOutput = directoryOutput;
		return this;
	}

	private File pathModelCSS() {
		return pathModelCSS;
	}

	private FlowMoreCSS pathModelCSS(File pathModelCSS) {
		this.pathModelCSS = pathModelCSS;
		return this;
	}

	public File directoryInput() {
		return directoryInput;
	}

	public FlowMoreCSS directoryInput(File directory) {
		this.directoryInput = directory;
		return this;
	}
	
	public Properties templateCSSProperties() {
		return templateCSSProperties;
	}

	public String nameTemplate() {
		return this.nameTemplate;
	}
	
	public FlowMoreCSS nameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
		return this;
	}

	/**
	 * factory method
	 * */
	public static FlowMoreCSS factory(String[] args) {
		FlowMoreCSS instanceCreated = null;
		if(null == args || args.length != 1){
    		System.err.println("Wrong arguments: it need only the path of configuration's file.");
    		System.exit(1);
    	}else{
    		instanceCreated = new FlowMoreCSS(args[0]);
    		instance = instanceCreated.init();
    	}
		return instanceCreated;
	}
	
	/**
	 * singleton
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public static FlowMoreCSS instance() {
		if(null == instance){
    		System.err.println("null instance");
    		System.exit(1);
    	}
		return instance.init();
	}
	
	/**
	 * @return initialized object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	protected FlowMoreCSS init() /* throws FileNotFoundException, IOException */{
		Properties propertiesEnvironment = new Properties();
		try {
			propertiesEnvironment.load(new BufferedReader(new FileReader(this.configurationFile().getAbsolutePath())));
			final File input = new File(propertiesEnvironment.getProperty(EnumKey.DIRECTORY_INPUT.name()));
			final File output = new File(propertiesEnvironment.getProperty(EnumKey.DIRECTORY_OUTPUT.name()));
			final File pathModelCSS = new File(propertiesEnvironment.getProperty(EnumKey.PATH_MODEL_CSS.name()));
			this.directoryInput(input).directoryOutput(output).pathModelCSS(pathModelCSS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(this);
		return this;
	}
	
	/**
	 * @effects: Build physical CSS files
	 * */
	protected void createsCSSThemesFromDirectory() throws IOException {
		File[] templates = loadAllTemplates();
		System.out.println("createsCSSThemesFromDirectory");
		for(File singleTemplate : templates){
			System.out.println("loadSingleTemplate("+singleTemplate+");");
			loadSingleTemplate(singleTemplate);
			List<RowCodeCSS> cssCode = useTemplateOverModelCSS();
			writeSingleCSSTheme(cssCode);
		}
	}
	
	/**
	 * @constructor
	 */
	private FlowMoreCSS(String a) {
		this.configurationFile= new File(a);
		this.templateCSSProperties = new  Properties();
	}
	
	
	
	/**
	 * @return array of <i>Files</i>, with termination <i>.properties</i>, that have the code CSS to insert
	 * */
	private File[] loadAllTemplates() throws IOException {
		File[] templates = this.directoryInput().listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(EnumKey.PROPERTIES.name());
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
		int extensionProperties = fileInput.getName().indexOf(".properties");
		nameTemplate(fileInput.getName().substring(0, extensionProperties).toUpperCase());
	}
	
	/**
	 * @return list of CSS code modified
	 * */
	private List<RowCodeCSS> useTemplateOverModelCSS() throws IOException {
		System.out.println("useTemplateOverModelCSS();");
		List<RowCodeCSS> row = new ArrayList<RowCodeCSS>();
    	BufferedReader templateCSSToRead = null;
    	try {
			templateCSSToRead = new BufferedReader(new FileReader(this.pathModelCSS().getAbsoluteFile()));
			String currentLine = null;
			while(null != ( currentLine = templateCSSToRead.readLine())){
				RowCodeCSS codeCSS = RowCodeCSS.instance(currentLine);
				if(currentLine.contains(EnumKey.FIRST.name())||currentLine.contains(EnumKey.SECOND.name())||currentLine.contains(EnumKey.THIRD.name())||currentLine.contains(EnumKey.FOURTH.name())){
					RowCodeCSS codeCSSSostituito = codeCSS.substitutes(templateCSSProperties());
					row.add(codeCSSSostituito);
				}else{
					row.add(codeCSS);
				}
				row.add(RowCodeCSS.instanceEmpty());

			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined model:" + e.getMessage());
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
	 * @param rows: list of CSS code modified and to print
	 * */
	private void writeSingleCSSTheme(List<RowCodeCSS> rows) throws IOException {
		StringBuilder fileThemeCSS = new StringBuilder(this.directoryOutput().getAbsolutePath()).append("\\").append(this.nameTemplate()).append( ".css");
		BufferedWriter newThemeCSSToWrite = null;
		try {
    		newThemeCSSToWrite = new BufferedWriter(new FileWriter(fileThemeCSS.toString()));
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlowMoreCSS [configurationFile=");
		builder.append(configurationFile());
		builder.append(", directoryInput=");
		builder.append(directoryInput());
		builder.append(", directoryOutput=");
		builder.append(directoryOutput());
		builder.append(", pathModelCSS=");
		builder.append(pathModelCSS());
		builder.append(", templateCSSProperties=");
		builder.append(templateCSSProperties());
		builder.append("]");
		return builder.toString();
	}
	
}